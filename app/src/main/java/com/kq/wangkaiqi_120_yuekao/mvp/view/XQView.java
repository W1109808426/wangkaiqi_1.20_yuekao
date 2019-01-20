package com.kq.wangkaiqi_120_yuekao.mvp.view;

import com.kq.wangkaiqi_120_yuekao.bean.ShopBean;
import com.kq.wangkaiqi_120_yuekao.bean.XiangQingBean;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public interface XQView {
    void OnScuess(XiangQingBean bean);
    void OnFailer(String msg);
}
