package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class ClassSortRequest implements Serializable {
    private int[] ids;

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }
}
