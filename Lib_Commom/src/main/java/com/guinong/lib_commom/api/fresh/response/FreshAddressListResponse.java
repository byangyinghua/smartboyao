package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangyu on 2019/1/11 0011.
 */

public class FreshAddressListResponse implements Serializable{


    /**
     * total : 0
     * current : 0
     * list : []
     */

    private int total;
    private int current;
    private List<FreshAddressResponse> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public List<FreshAddressResponse> getList() {
        return list;
    }

    public void setList(List<FreshAddressResponse> list) {
        this.list = list;
    }
}
