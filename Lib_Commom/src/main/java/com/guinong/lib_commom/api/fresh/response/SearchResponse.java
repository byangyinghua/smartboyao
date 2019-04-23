package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;
import java.util.List;

public class SearchResponse implements Serializable {

    /**
     * total : 2
     * current : 1
     * list : [{"createTime":"2019-01-08 18:20:02","modifyTime":"2019-01-29 09:53:11","id":2,"name":"白汤火锅","data":{"pic":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1254224517,35416304&fm=173&app=25&f=JPEG?w=218&h=146&s=B544954E8F789A4D62492D2C0300C012"},"unit":"kg","unitPrice":5000,"description":"白汤锅底","status":"ENABLE","shopId":5,"productTypeId":4,"shop":{"id":5,"name":"老火锅","longitude":109.12389201,"latitude":25.102321,"address":"贵阳市观山湖区"}},{"createTime":"2019-01-08 18:19:39","modifyTime":"2019-01-29 09:53:08","id":1,"name":"酸汤火锅","data":{"pic":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1254224517,35416304&fm=173&app=25&f=JPEG?w=218&h=146&s=B544954E8F789A4D62492D2C0300C012"},"unit":"kg","unitPrice":5000,"description":"酸汤锅底","status":"ENABLE","shopId":5,"productTypeId":4,"shop":{"id":5,"name":"老火锅","longitude":109.12389201,"latitude":25.102321,"address":"贵阳市观山湖区"}}]
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
         * createTime : 2019-01-08 18:20:02
         * modifyTime : 2019-01-29 09:53:11
         * id : 2
         * name : 白汤火锅
         * data : {"pic":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1254224517,35416304&fm=173&app=25&f=JPEG?w=218&h=146&s=B544954E8F789A4D62492D2C0300C012"}
         * unit : kg
         * unitPrice : 5000
         * description : 白汤锅底
         * status : ENABLE
         * shopId : 5
         * productTypeId : 4
         * shop : {"id":5,"name":"老火锅","longitude":109.12389201,"latitude":25.102321,"address":"贵阳市观山湖区"}
         */

        private String createTime;
        private String modifyTime;
        private int id;
        private String name;
        private DataBean data;
        private String unit;
        private int unitPrice;
        private String description;
        private String status;
        private int shopId;
        private int productTypeId;
        private ShopBean shop;

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

        public int getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(int unitPrice) {
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

        public ShopBean getShop() {
            return shop;
        }

        public void setShop(ShopBean shop) {
            this.shop = shop;
        }

        public static class DataBean implements Serializable {
            /**
             * pic : https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1254224517,35416304&fm=173&app=25&f=JPEG?w=218&h=146&s=B544954E8F789A4D62492D2C0300C012
             */

            private String pic;

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }
        }

        public static class ShopBean implements Serializable {
            /**
             * id : 5
             * name : 老火锅
             * longitude : 109.12389201
             * latitude : 25.102321
             * address : 贵阳市观山湖区
             */

            private int id;
            private String name;
            private double longitude;
            private double latitude;
            private String address;

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

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }
        }
    }
}
