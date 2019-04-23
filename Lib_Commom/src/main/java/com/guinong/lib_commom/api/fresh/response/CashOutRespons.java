package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;

public class CashOutRespons implements Serializable {


    /**
     * applyFee : 100
     * taxFee : 0
     * remainFee : 88
     * status : PREPARE
     * applyType : ALI
     * applyNo : 134134@ss
     * applyName : 张三
     * userId : 70037
     * account : {"userId":70037,"phone":"13698564523"}
     */

    private int applyFee;
    private double taxFee;
    private double remainFee;
    private String status;
    private String applyType;
    private String applyNo;
    private String applyName;
    private int userId;
    private AccountBean account;

    public int getApplyFee() {
        return applyFee;
    }

    public void setApplyFee(int applyFee) {
        this.applyFee = applyFee;
    }

    public double getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(double taxFee) {
        this.taxFee = taxFee;
    }

    public double getRemainFee() {
        return remainFee;
    }

    public void setRemainFee(double remainFee) {
        this.remainFee = remainFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public static class AccountBean implements Serializable {
        /**
         * userId : 70037
         * phone : 13698564523
         */

        private int userId;
        private String phone;

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
    }
}
