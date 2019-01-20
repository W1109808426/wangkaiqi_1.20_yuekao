package com.kq.wangkaiqi_120_yuekao.net;

import com.kq.wangkaiqi_120_yuekao.bean.ShopBean;
import com.kq.wangkaiqi_120_yuekao.bean.XiangQingBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public interface Draww {
    @GET("product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1")
    Observable<ShopBean> getShop();

    @GET("/product/getProductDetail")
    Observable<XiangQingBean> getXQ(@Query("pid") int pid);
}
