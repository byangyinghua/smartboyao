package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class ShopStatusRequest implements Serializable {
    private String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
