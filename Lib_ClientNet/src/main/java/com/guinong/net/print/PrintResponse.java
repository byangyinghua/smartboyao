package com.guinong.net.print;

import java.io.Serializable;

public class PrintResponse implements Serializable {

    /**
     * id :
     * status :
     */

    private String id;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
