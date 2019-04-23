package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;

public class PhoneCodeResponse implements Serializable {

    /**
     * type : QUICK_LOGIN
     * phone : 1878667854
     * code : 666666
     */

    private String type;
    private String phone;
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
