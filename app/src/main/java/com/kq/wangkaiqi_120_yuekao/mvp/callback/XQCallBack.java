package com.kq.wangkaiqi_120_yuekao.mvp.callback;

import com.kq.wangkaiqi_120_yuekao.bean.XiangQingBean;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public interface XQCallBack {
    void OnScuess(XiangQingBean bean);
    void OnFailer(String msg);
}
