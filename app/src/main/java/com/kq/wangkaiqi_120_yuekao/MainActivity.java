package com.kq.wangkaiqi_120_yuekao;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kq.wangkaiqi_120_yuekao.adapter.ShopAdapter;
import com.kq.wangkaiqi_120_yuekao.bean.ShopBean;
import com.kq.wangkaiqi_120_yuekao.mvp.persenter.ShopPersenter;
import com.kq.wangkaiqi_120_yuekao.mvp.view.ShopView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ShopView {

    @BindView(R.id.Recyc)
    RecyclerView Recyc;
    @BindView(R.id.DingWei)
    TextView DingWei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ShopPersenter shopPersenter=new ShopPersenter(this);
        shopPersenter.getShop();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(App.mContext,LinearLayoutManager.VERTICAL,false);
        Recyc.setLayoutManager(linearLayoutManager);

        DingWei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ThreeActivity.class));
            }
        });
    }

    @Override
    public void OnScuess(ShopBean shopBean) {
        if (shopBean!=null){
            ShopAdapter shopAdapter=new ShopAdapter(App.mContext,shopBean.getData());
            Recyc.setAdapter(shopAdapter);
            //点击条目,跳转详情
            shopAdapter.setOnClickL(new ShopAdapter.OnClickL() {
                @Override
                public void Click(int id) {
                    Intent intent=new Intent(MainActivity.this,TwoActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            });

            //长按删除条目
            /*shopAdapter.setOnClickLong(new ShopAdapter.OnClickLong() {
                @Override
                public void LongClick() {
                    ObjectAnimator animator=new ObjectAnimator()
                }
            });*/
        }
    }

    @Override
    public void OnFailer(String msg) {

    }
}
