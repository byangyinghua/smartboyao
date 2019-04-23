package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;

public class ShopStatusResponse implements Serializable {

    /**
     * userId : 1000011
     * shopId : 11
     * shopStatus : ENABLE
     * shopStatusStr : 当状态异常（冻结，审核拒绝）时，必须传此参数
     */

    private int userId;
    private int shopId;
    private String shopStatus;
    private String shopStatusStr;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getShopStatusStr() {
        return shopStatusStr;
    }

    public void setShopStatusStr(String shopStatusStr) {
        this.shopStatusStr = shopStatusStr;
    }
}
