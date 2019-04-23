package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;
import java.util.List;

public class ClassDataResponse implements Serializable {

    /**
     * total : 4
     * current : 1
     * list : [{"createTime":"2019-01-10 11:35:31","modifyTime":"2019-01-10 11:35:31","id":7,"sort":2,"name":"零食","shopId":2},{"createTime":"2019-01-10 11:35:40","modifyTime":"2019-01-10 11:35:40","id":8,"sort":1,"name":"水果","shopId":2},{"createTime":"2019-01-10 11:35:45","modifyTime":"2019-01-10 11:35:45","id":9,"sort":4,"name":"蔬菜","shopId":2},{"createTime":"2019-01-10 11:35:53","modifyTime":"2019-01-10 11:35:53","id":10,"sort":3,"name":"茶叶","shopId":2}]
     */

    private int total;
    private int current;
    private List<ListBean> list;

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

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable {
        /**
         * createTime : 2019-01-10 11:35:31
         * modifyTime : 2019-01-10 11:35:31
         * id : 7
         * sort : 2
         * name : 零食
         * shopId : 2
         */

        private String createTime;
        private String modifyTime;
        private int id;
        private int sort;
        private String name;
        private int shopId;
        private int productNum;

        public int getProductNum() {
            return productNum;
        }

        public void setProductNum(int productNum) {
            this.productNum = productNum;
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
}
