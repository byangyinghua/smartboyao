package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

/**
 * @author wangyu
 * @time 2017/8/1 0001 on 下午 14:38
 * @desc
 */
public class OrdersRequest implements Serializable {

    private int page;
    private int pageSize;
    private int shopId;
    private String status;
    private String refundStatus;
    private String statusList;
    private String refundType;

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public String getStatusList() {
        return statusList;
    }

    public void setStatusList(String statusList) {
        this.statusList = statusList;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
