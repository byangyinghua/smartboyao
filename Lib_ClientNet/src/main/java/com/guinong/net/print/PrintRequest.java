package com.guinong.net.print;

import java.io.Serializable;

public class PrintRequest implements Serializable {
    private String appid;
    private String sign;
    private String devicesecret;
    private String printdata;
    private String deviceid;
    private long timestamp;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDevicesecret() {
        return devicesecret;
    }

    public void setDevicesecret(String devicesecret) {
        this.devicesecret = devicesecret;
    }

    public String getPrintdata() {
        return printdata;
    }

    public void setPrintdata(String printdata) {
        this.printdata = printdata;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
