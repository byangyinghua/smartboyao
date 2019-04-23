package com.guinong.lib_base.bean;

import java.io.Serializable;

/**
 * @author wangyu
 * @time 2017/12/15 0015 on 上午 10:21
 * @desc
 */
public class ShareDataBean implements Serializable{

    private String[] shareNames;
    private int[] shareIcons;

    public String[] getShareNames() {
        return shareNames;
    }

    public void setShareNames(String[] shareNames) {
        this.shareNames = shareNames;
    }

    public int[] getShareIcons() {
        return shareIcons;
    }

    public void setShareIcons(int[] shareIcons) {
        this.shareIcons = shareIcons;
    }
}
