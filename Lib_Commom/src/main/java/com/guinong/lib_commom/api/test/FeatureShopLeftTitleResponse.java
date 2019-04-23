package com.guinong.lib_commom.api.test;

import java.io.Serializable;
import java.util.List;

public class FeatureShopLeftTitleResponse implements Serializable {


    private List<TypeListBean> typeList;
    private List<ProductListBean> productList;

    public List<TypeListBean> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TypeListBean> typeList) {
        this.typeList = typeList;
    }

    public List<ProductListBean> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductListBean> productList) {
        this.productList = productList;
    }

    public static class TypeListBean implements Serializable {
        /**
         * createTime : 2019-01-10 11:35:53
         * modifyTime : 2019-01-10 11:35:53
         * id : 10
         * sort : 3
         * name : 茶叶
         * shopId : 2
         */

        private String createTime;
        private String modifyTime;
        private int id;
        private int sort;
        private String name;
        private int shopId;
        private boolean isSeletc;
        private int productNum;

        public int getProductNum() {
            return productNum;
        }

        public void setProductNum(int productNum) {
            this.productNum = productNum;
        }

        public boolean isSeletc() {
            return isSeletc;
        }

        public void setSeletc(boolean seletc) {
            isSeletc = seletc;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
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

    public static class ProductListBean implements Serializable {
        /**
         * createTime : 2019-01-10 11:41:06
         * modifyTime : 2019-01-10 17:16:58
         * id : 22
         * name : 龙井
         * data : {"mainPic":"一张图片"}
         * unit : 250kg
         * unitPrice : 1000
         * description : 还行
         * status : ENABLE
         * shopId : 2
         * productTypeId : 10
         */
        private String className;
        private String createTime;
        private String modifyTime;
        private Integer id;
        private String name;
        private DataBean data;
        private String unit;
        private double unitPrice;
        private String description;
        private String status;
        private int shopId;
        private int productTypeId;
        private boolean isEdit;

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public boolean isEdit() {
            return isEdit;
        }

        public void setEdit(boolean edit) {
            isEdit = edit;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public Integer getId() {
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public int getProductTypeId() {
            return productTypeId;
        }

        public void setProductTypeId(int productTypeId) {
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
}
