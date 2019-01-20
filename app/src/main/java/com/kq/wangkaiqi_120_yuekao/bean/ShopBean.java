package com.kq.wangkaiqi_120_yuekao.bean;

import java.util.List;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public class ShopBean {
    private String msg;

    private String code;

    private List<Data> data;

    private String page;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return this.data;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return this.page;
    }

    public class Data {
        private double bargainPrice;

        private String createtime;

        private String detailUrl;

        private String images;

        private int itemtype;

        private int pid;

        private double price;

        private int pscid;

        private int salenum;

        private int sellerid;

        private String subhead;

        private String title;

        public void setBargainPrice(double bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        public double getBargainPrice() {
            return this.bargainPrice;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getDetailUrl() {
            return this.detailUrl;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getImages() {
            return this.images;
        }

        public void setItemtype(int itemtype) {
            this.itemtype = itemtype;
        }

        public int getItemtype() {
            return this.itemtype;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getPid() {
            return this.pid;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPscid(int pscid) {
            this.pscid = pscid;
        }

        public int getPscid() {
            return this.pscid;
        }

        public void setSalenum(int salenum) {
            this.salenum = salenum;
        }

        public int getSalenum() {
            return this.salenum;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }

        public int getSellerid() {
            return this.sellerid;
        }

        public void setSubhead(String subhead) {
            this.subhead = subhead;
        }

        public String getSubhead() {
            return this.subhead;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }

    }
}
