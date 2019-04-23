package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class UpLoadDishDataRequest implements Serializable {

    /**
     * id : 1
     * name : 第二个商品
     * data : {"mainPic":"一张图片"}
     * unit : kg
     * unitPrice : 5000
     * description : 一件商品
     * shopId : 1
     * productTypeId : 1
     */

    private int id;
    private String name;
    private DataBean data;
    private String unit;
    private double unitPrice;
    private String description;
    private int shopId;
    private String productTypeId;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public static class DataBean implements Serializable {
        /**
         * mainPic : 一张图片
         */

        private String mainPic;

        public String getMainPic() {
            return mainPic;
        }

        public void setMainPic(String mainPic) {
            this.mainPic = mainPic;
        }
    }
}
