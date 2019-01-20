package com.kq.wangkaiqi_120_yuekao.mvp.persenter;

import com.kq.wangkaiqi_120_yuekao.bean.XiangQingBean;
import com.kq.wangkaiqi_120_yuekao.mvp.callback.XQCallBack;
import com.kq.wangkaiqi_120_yuekao.mvp.model.XQModel;
import com.kq.wangkaiqi_120_yuekao.mvp.view.XQView;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public class XQpersenter {
    private XQView view;
    private XQModel model;

    public XQpersenter(XQView view) {
        this.view = view;
        model=new XQModel();
    }

    public void getX(int id){
        model.getX(id, new XQCallBack() {
            @Override
            public void OnScuess(XiangQingBean bean) {
                view.OnScuess(bean);
            }

            @Override
            public void OnFailer(String msg) {

            }
        });
    }
}
