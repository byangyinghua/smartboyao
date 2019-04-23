package com.guinong.net;

import java.io.Serializable;

public class YnwLoginRequest implements Serializable {
    private String appid;
    private String authCode;
    private String accessToken;
    private String accessAccount;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessAccount() {
        return accessAccount;
    }

    public void setAccessAccount(String accessAccount) {
        this.accessAccount = accessAccount;
    }
}
