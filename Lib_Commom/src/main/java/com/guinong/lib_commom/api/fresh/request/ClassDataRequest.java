package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class ClassDataRequest implements Serializable {
    private int shopId;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
