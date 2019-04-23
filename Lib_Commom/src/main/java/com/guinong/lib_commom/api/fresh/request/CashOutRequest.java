package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class CashOutRequest implements Serializable {


    /**
     * applyFee : 100000
     * applyType : ALI
     * applyNo : 134134@ss
     * applyName : 张三
     * userId : 0
     * verifyCode : {"type":"APPLY_WITHDRAW_REBATE","phone":"","code":""}
     */

    private int applyFee;
    private String applyType;
    private String applyNo;
    private String applyName;
    private int userId;
    private VerifyCodeBean verifyCode;

    public int getApplyFee() {
        return applyFee;
    }

    public void setApplyFee(int applyFee) {
        this.applyFee = applyFee;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public VerifyCodeBean getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(VerifyCodeBean verifyCode) {
        this.verifyCode = verifyCode;
    }

    public static class VerifyCodeBean implements Serializable {
        /**
         * type : APPLY_WITHDRAW_REBATE
         * phone :
         * code :
         */

        private String type;
        private String phone;
        private String code;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
