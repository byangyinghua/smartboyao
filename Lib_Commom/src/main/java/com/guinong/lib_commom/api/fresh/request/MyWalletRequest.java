package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class MyWalletRequest implements Serializable {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
