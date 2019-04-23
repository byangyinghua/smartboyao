package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

/**
 * @author wangyu
 * @time 2017/8/1 0001 on 下午 14:38
 * @desc
 */
public class RefuneBackRequest implements Serializable {
    private String serialNum;
    private String status;
    private String rejectReason;

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }
}
