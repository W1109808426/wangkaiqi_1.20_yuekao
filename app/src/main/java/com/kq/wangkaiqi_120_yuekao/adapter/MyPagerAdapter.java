package com.kq.wangkaiqi_120_yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kq.wangkaiqi_120_yuekao.App;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<String> dataBeans ;

    public MyPagerAdapter(Context mContext, List<String> dataBeans) {
        this.mContext = mContext;
        this.dataBeans = dataBeans;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //String s = dataBeans.get(position);
        ImageView imageView = new ImageView(mContext);
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
