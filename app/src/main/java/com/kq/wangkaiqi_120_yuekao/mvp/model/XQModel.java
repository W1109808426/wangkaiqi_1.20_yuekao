package com.kq.wangkaiqi_120_yuekao.mvp.model;

import com.kq.wangkaiqi_120_yuekao.bean.ShopBean;
import com.kq.wangkaiqi_120_yuekao.bean.XiangQingBean;
import com.kq.wangkaiqi_120_yuekao.mvp.callback.ShopCallBack;
import com.kq.wangkaiqi_120_yuekao.mvp.callback.XQCallBack;
import com.kq.wangkaiqi_120_yuekao.net.Draww;
import com.kq.wangkaiqi_120_yuekao.net.RetrofitApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public class XQModel {
    public void getX(int pid,final XQCallBack callBack) {
        Draww api = RetrofitApi.getInstance().createApi(Draww.class);
        api.getXQ(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<XiangQingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.OnFailer(e.getMessage());
                    }

                    @Override
                    public void onNext(XiangQingBean bean) {
                        callBack.OnScuess(bean);
                    }
                });
    }
}
