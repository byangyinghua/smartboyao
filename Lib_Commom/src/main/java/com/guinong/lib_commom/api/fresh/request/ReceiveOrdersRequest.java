package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

/**
 * @author wangyu
 * @time 2017/8/1 0001 on 下午 14:38
 * @desc
 */
public class ReceiveOrdersRequest implements Serializable {
    private String serialNum;

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }
}
