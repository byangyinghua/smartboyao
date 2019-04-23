package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    /**
     * userId : 1000011
     * phone : 13911103482
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRlIjoxNTQ3MTc2NzY4Nzc2LCJleHAiOjE1NDc3ODE1NjgsImNvbnRlbnQiOiIxMDAwMDExIn0.Nb4qJB3bvMPC-CLYxyjKo2hSM4Ek8sMxpJOkKWXavG0
     * refreshToken : 5dc6951cb5fc5da8680d67680e2fd4f7f2a66bf2b44177ecb9399f8a395aca66
     * shopId : 11
     * shopStatus : ENABLE
     * shopStatusStr : 当状态异常（冻结，审核拒绝）时，必须传此参数
     */

    private int userId;
    private String phone;
    private String token;
    private String refreshToken;
    private Integer shopId;
    private String shopStatus;
    private String shopStatusStr;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
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
