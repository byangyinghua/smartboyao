package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;

public class PushTokenResponse implements Serializable {


    /**
     * code : 200
     * userId : 15
     * token : ew/CZKjufNq86uSAtc0c/uOUG/L3uaHgiT1Lf4PFshU3NBsbxhHs8m3QhDwp84y332oc573Gwe2POaKGqTSSqg==
     */

    private int code;
    private String userId;
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
