package com.guinong.lib_commom.api.test;

import java.io.Serializable;

public class DashEditRequest implements Serializable {

    /**
     * id : 16
     * name : 苹果
     * status : DISABLE
     */

    private String id;
    private String name;
    private String status;
    private boolean del;

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
