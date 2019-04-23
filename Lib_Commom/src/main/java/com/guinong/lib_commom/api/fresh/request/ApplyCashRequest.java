package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class ApplyCashRequest implements Serializable {
    /**
     * applyFee : 100000
     * applyType : ALI
     * applyNo : 134134@ss
     * applyName : 张三
     * userId : 0
     */

    private String applyFee;
    private String applyType;
    private String applyNo;
    private String applyName;
    private int userId;

    public String getApplyFee() {
        return applyFee;
    }

    public void setApplyFee(String applyFee) {
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
}
