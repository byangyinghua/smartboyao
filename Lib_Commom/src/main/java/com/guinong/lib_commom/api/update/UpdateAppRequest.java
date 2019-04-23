package com.guinong.lib_commom.api.update;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/2.
 */
public class UpdateAppRequest implements Serializable {

    private String appVersion;
    //2安卓，3IOS
    private String type;

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
