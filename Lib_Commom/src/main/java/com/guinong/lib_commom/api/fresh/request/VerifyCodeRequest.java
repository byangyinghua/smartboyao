package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

/**
 * Created by wangyu on 2018/8/6 0006.
 */

public class VerifyCodeRequest implements Serializable{

    private String phone;
    private String type;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
