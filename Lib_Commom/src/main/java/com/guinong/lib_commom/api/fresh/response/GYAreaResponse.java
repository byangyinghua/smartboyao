package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;

/**
 * Created by wangyu on 2019/1/8 0008.
 */

public class GYAreaResponse implements Serializable{

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
