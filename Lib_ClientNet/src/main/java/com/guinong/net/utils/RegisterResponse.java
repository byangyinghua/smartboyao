package com.guinong.net.utils;

/**
 * Created by Administrator on 2017/7/31.
 */
public class RegisterResponse {
    private ResultBean result;
    private boolean success;
    private ErrorBean error;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public static class ResultBean {
        /**
         * id : 40329
         * userName : 18785083419
         * email :
         * topRegionId : 0
         * regionId : 0
         * cellPhone : 18785083419
         * qq : null
         * nick : 18785083419
         * photo : null
         * sex : 0
         * ticket : e911d04287aa408d8ba0911e0e2f4752
         */

        private int id;
        private String userName;
        private String email;
        private int topRegionId;
        private int regionId;
        private String cellPhone;
        private String qq;
        private String nick;
        private String photo;
        private int sex;
        private String ticket;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getTopRegionId() {
            return topRegionId;
        }

        public void setTopRegionId(int topRegionId) {
            this.topRegionId = topRegionId;
        }

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public String getCellPhone() {
            return cellPhone;
        }

        public void setCellPhone(String cellPhone) {
            this.cellPhone = cellPhone;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

    }

    public static class ErrorBean {
        /**
         * code : 103
         * message : 用户名或密码错误
         * details :
         */

        private String code;
        private String message;
        private String details;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

}
