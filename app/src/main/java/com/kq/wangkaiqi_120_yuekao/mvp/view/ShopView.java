package com.kq.wangkaiqi_120_yuekao.mvp.view;

import com.kq.wangkaiqi_120_yuekao.bean.ShopBean;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public interface ShopView {
    void OnScuess(ShopBean shopBean);
    void OnFailer(String msg);
}
