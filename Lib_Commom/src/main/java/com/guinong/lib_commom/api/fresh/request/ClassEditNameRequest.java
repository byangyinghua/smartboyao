package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class ClassEditNameRequest implements Serializable {

    /**
     * id : 1
     * name : 一个分类
     * shopId : 1
     */

    private Integer id;
    private String name;
    private int shopId;
    private boolean del;

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
