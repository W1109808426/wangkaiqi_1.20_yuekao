package com.kq.wangkaiqi_120_yuekao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kq.wangkaiqi_120_yuekao.adapter.MyPagerAdapter;
import com.kq.wangkaiqi_120_yuekao.bean.XiangQingBean;
import com.kq.wangkaiqi_120_yuekao.mvp.persenter.XQpersenter;
import com.kq.wangkaiqi_120_yuekao.mvp.view.XQView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TwoActivity extends AppCompatActivity implements XQView {

    private static final String TAG = "TwoActivity";
    @BindView(R.id.ViewPager)
    android.support.v4.view.ViewPager ViewPager;
    @BindView(R.id.XName)
    TextView XName;
    @BindView(R.id.XNameT)
    TextView XNameT;
    @BindView(R.id.XPrice)
    TextView XPrice;
    private String[] split;
    private List<String> dataBeans = new ArrayList<String>();

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    ViewPager.setCurrentItem(ViewPager.getCurrentItem() + 1);
                    handler.sendEmptyMessageDelayed(0, 2000);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        XQpersenter xQpersenter = new XQpersenter(this);
        xQpersenter.getX(id);
    }

    private void initData() {
        ViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler.removeMessages(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        handler.removeMessages(0);
                        break;
                    case MotionEvent.ACTION_UP:
                        handler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        handler.sendEmptyMessage(0);
    }

    @Override
    public void OnScuess(XiangQingBean bean) {
        if (bean != null) {
            XiangQingBean.DataBean data = bean.getData();
            for (int i = 0; i < data.getImages().length(); i++) {
                String images = data.getImages();
                split = images.split("\\|");
            }
            for (int j = 0; j < split.length; j++) {
                dataBeans.add(split[j]);
                //viewHolder.ShopImage.setImageURI(Uri.parse(split[j]));
            }
            MyPagerAdapter myPagerAdapter = new MyPagerAdapter(App.mContext, dataBeans);
            ViewPager.setAdapter(new myAdapter());
            XName.setText(data.getTitle());
            XPrice.setText("¥" + data.getPrice());
            XNameT.setText(data.getSubhead());
        }
    }

    @Override
    public void OnFailer(String msg) {

    }

    public class myAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            //String s = dataBeans.get(position);
            ImageView imageView = new ImageView(App.mContext);
            for (int i = 0; i < dataBeans.size(); i++) {
                Picasso.with(App.mContext).load(dataBeans.get(i)).into(imageView);
            }
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
