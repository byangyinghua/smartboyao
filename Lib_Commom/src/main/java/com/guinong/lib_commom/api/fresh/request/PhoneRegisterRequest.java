package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class PhoneRegisterRequest implements Serializable {

    /**
     * phone : 13911103481
     * verifyCode : {"type":"QUICK_LOGIN","code":"666666","phone":"13911103483"}
     */

    private String phone;
    private VerifyCodeBean verifyCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public VerifyCodeBean getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(VerifyCodeBean verifyCode) {
        this.verifyCode = verifyCode;
    }

    public static class VerifyCodeBean implements Serializable {
        /**
         * type : QUICK_LOGIN
         * code : 666666
         * phone : 13911103483
         */

        private String type;
        private String code;
        private String phone;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
