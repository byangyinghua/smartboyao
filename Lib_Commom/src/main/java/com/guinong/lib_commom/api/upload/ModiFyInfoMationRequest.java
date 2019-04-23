package com.guinong.lib_commom.api.upload;

/**
 * Created by wangyu on 2018/9/19 0019.
 */

public class ModiFyInfoMationRequest {


    /**
     * userId : 126
     * name : 测试名称
     * avatar : /jlkslg.png
     * gender : MALE
     */

    private int userId;
    private String name;
    private String avatar;
    private String gender;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
