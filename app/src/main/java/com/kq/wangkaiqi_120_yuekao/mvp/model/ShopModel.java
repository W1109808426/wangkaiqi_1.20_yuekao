package com.kq.wangkaiqi_120_yuekao.mvp.model;

import com.kq.wangkaiqi_120_yuekao.bean.ShopBean;
import com.kq.wangkaiqi_120_yuekao.mvp.callback.ShopCallBack;
import com.kq.wangkaiqi_120_yuekao.net.Draww;
import com.kq.wangkaiqi_120_yuekao.net.RetrofitApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public class ShopModel {
    public void getShop(final ShopCallBack callBack) {
        Draww api = RetrofitApi.getInstance().createApi(Draww.class);
        api.getShop()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ShopBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.OnFailer(e.getMessage());
                    }

                    @Override
                    public void onNext(ShopBean shopBean) {
                        callBack.OnScuess(shopBean);
                    }
                });
    }
}
