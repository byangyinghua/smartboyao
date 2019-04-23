package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class PushTokenRequest implements Serializable {

    /**
     * userId : 15
     * name : wangsl
     * portraitUri : jfskl
     */

    private int userId;
    private String name;
    private String portraitUri;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortraitUri() {
        return portraitUri;
    }

    public void setPortraitUri(String portraitUri) {
        this.portraitUri = portraitUri;
    }
}
