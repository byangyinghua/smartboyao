package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class PhoneCodeRequest implements Serializable {

    /**
     * type : QUICK_LOGIN
     * phone : 1878667854
     * code : 666666
     */

    private String type;
    private String phone;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
