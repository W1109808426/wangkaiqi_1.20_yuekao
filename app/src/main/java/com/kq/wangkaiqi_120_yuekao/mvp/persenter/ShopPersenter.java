package com.kq.wangkaiqi_120_yuekao.mvp.persenter;

import com.kq.wangkaiqi_120_yuekao.bean.ShopBean;
import com.kq.wangkaiqi_120_yuekao.mvp.callback.ShopCallBack;
import com.kq.wangkaiqi_120_yuekao.mvp.model.ShopModel;
import com.kq.wangkaiqi_120_yuekao.mvp.view.ShopView;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public class ShopPersenter {
    private ShopView shopView;
    private ShopModel shopModel;

    public ShopPersenter(ShopView shopView) {
        this.shopView = shopView;
        shopModel = new ShopModel();
    }

    public void getShop() {
        shopModel.getShop(new ShopCallBack() {
            @Override
            public void OnScuess(ShopBean shopBean) {
                shopView.OnScuess(shopBean);
            }

            @Override
            public void OnFailer(String msg) {
                shopView.OnFailer(msg);
            }
        });
    }
}
