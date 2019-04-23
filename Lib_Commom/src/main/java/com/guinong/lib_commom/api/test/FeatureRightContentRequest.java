package com.guinong.lib_commom.api.test;

public class FeatureRightContentRequest {
    private String shopId;
    private String status;
    private String productTypeId;
    private String productName;

    public String getShopid() {
        return shopId;
    }

    public void setShopid(String shopid) {
        this.shopId = shopid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
