package com.kq.wangkaiqi_120_yuekao;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.jpush.android.api.JPushInterface;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public class App extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        Fresco.initialize(this);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
