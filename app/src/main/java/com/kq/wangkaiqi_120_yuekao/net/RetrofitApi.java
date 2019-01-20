package com.kq.wangkaiqi_120_yuekao.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public class RetrofitApi {
    private static RetrofitApi instance;
    private final Retrofit retrofit;

    public static RetrofitApi getInstance(){
        if (instance==null){
            instance=new RetrofitApi();
        }
        return instance;
    }

    private RetrofitApi(){
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(3000,TimeUnit.MILLISECONDS)
                .readTimeout(3000,TimeUnit.MILLISECONDS)
                .connectTimeout(3000,TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public <T> T createApi(Class<T> cls){
        T t =retrofit.create(cls);
        return t;
    }
}
