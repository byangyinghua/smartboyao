package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;

public class PhoneRegisterResponse implements Serializable {

    /**
     * status : SUCCESS
     * message : 注册成功
     * data : {"userId":1000016,"phone":"13911103481","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRlIjoxNTQ3MTEzODk4NjE2LCJleHAiOjE1NDc3MTg2OTgsImNvbnRlbnQiOiIxMDAwMDE2In0.-lTbcf7s8BkQ10A0pgnLHnOUX4JdRt9YOdwETvnCpK4","refreshToken":"d59140f1ecb9dbb7d5214283edeca08f4b5d54ecb8261c3629d52398a9a674d1"}
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
         * userId : 1000016
         * phone : 13911103481
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRlIjoxNTQ3MTEzODk4NjE2LCJleHAiOjE1NDc3MTg2OTgsImNvbnRlbnQiOiIxMDAwMDE2In0.-lTbcf7s8BkQ10A0pgnLHnOUX4JdRt9YOdwETvnCpK4
         * refreshToken : d59140f1ecb9dbb7d5214283edeca08f4b5d54ecb8261c3629d52398a9a674d1
         */

        private int userId;
        private String phone;
        private String token;
        private String refreshToken;

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
    }
}
