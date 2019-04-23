package com.guinong.lib_commom.api.update;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/2.
 */
public class UpdateAppResponse implements Serializable {


    /**
     * description : 1.追加评价功能开启。
     2.场馆界面调整
     3.优化退货功能
     4.优化物流助手
     * downLoadUrl : http://www.guinong.com/appupdate/guinong.apk
     * isAdviseUpdate : true
     * isMustUpdate : false
     * size:15
     * vision:3.0.4
     */

    private String description;
    private String downLoadUrl;
    private String vision;
    private boolean isAdviseUpdate;
    private boolean isMustUpdate;
    private double size;

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownLoadUrl() {
        return downLoadUrl;
    }

    public void setDownLoadUrl(String downLoadUrl) {
        this.downLoadUrl = downLoadUrl;
    }

    public boolean isIsAdviseUpdate() {
        return isAdviseUpdate;
    }

    public void setIsAdviseUpdate(boolean isAdviseUpdate) {
        this.isAdviseUpdate = isAdviseUpdate;
    }

    public boolean isIsMustUpdate() {
        return isMustUpdate;
    }

    public void setIsMustUpdate(boolean isMustUpdate) {
        this.isMustUpdate = isMustUpdate;
    }
}