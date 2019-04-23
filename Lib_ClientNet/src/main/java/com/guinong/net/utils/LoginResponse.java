package com.guinong.net.utils;

import java.io.Serializable;

public class LoginResponse implements Serializable {


    /**
     * status : SUCCESS
     * message : 登录成功
     * data : {"userId":1000011,"phone":"13911103482","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRlIjoxNTQ3MTc2NjY1NTU3LCJleHAiOjE1NDc3ODE0NjUsImNvbnRlbnQiOiIxMDAwMDExIn0.m7yyExGtsBthLYxUX8GTm5YtOKDX3CzKWxDA014EVIY","refreshToken":"476122ccfc63ea186e97881f32d9be1459df9cec98851a68f8773f764d0f1af9","shopId":11,"shopStatus":"ENABLE","shopStatusStr":"当状态异常（冻结，审核拒绝）时，必须传此参数"}
     */

    private String status;
    private String message;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * userId : 1000011
         * phone : 13911103482
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRlIjoxNTQ3MTc2NjY1NTU3LCJleHAiOjE1NDc3ODE0NjUsImNvbnRlbnQiOiIxMDAwMDExIn0.m7yyExGtsBthLYxUX8GTm5YtOKDX3CzKWxDA014EVIY
         * refreshToken : 476122ccfc63ea186e97881f32d9be1459df9cec98851a68f8773f764d0f1af9
         * shopId : 11
         * shopStatus : ENABLE
         * shopStatusStr : 当状态异常（冻结，审核拒绝）时，必须传此参数
         */

        private int userId;
        private String phone;
        private String token;
        private String refreshToken;
        private int shopId;
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
}
