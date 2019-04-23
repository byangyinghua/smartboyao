package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangyu
 * @time 2017/8/1 0001 on 下午 14:40
 * @desc
 */
public class OrdersResponse implements Serializable {

    /**
     * total : 1
     * current : 1
     * list : [{"createTime":"2019-01-18 10:09:32","modifyTime":"2019-01-18 10:09:55","id":56,"serialNum":"2019011810093180460ORDER_INFO","status":"WAITING_TAKE","address":{"id":6,"name":"王宇","phone":"18089697084","detail":"高新区高科国际西部国际软件园&大数据中心","userId":121,"latitude":26.618877,"location":"贵州省贵阳市观山湖区高新区高科国际西部国际软件园&大数据中心","longitude":106.646679,"createTime":"2019-01-16 09:44:26","modifyTime":"2019-01-16 09:44:26"},"totalNum":1,"totalFee":1,"sendFee":0,"finalFee":1,"taxFee":0,"packageFee":0,"remark":"","cancelEndTime":"2019-01-18 10:29:32","distance":0.0366474843960767,"userId":1302,"payId":6,"shopId":36,"shopName":"季新杰","orderItemList":[{"createTime":"2019-01-18 10:09:32","modifyTime":"2019-01-18 10:09:32","id":99,"num":1,"product":{"id":51,"data":{"mainPic":"static/201901/8da5e2f1-1540-4b9a-9ccb-dff8c83c80f8.jpg"},"name":"测试商品","unit":"500kg","shopId":36,"status":"ENABLE","unitPrice":1,"createTime":"2019-01-17 16:24:32","modifyTime":"2019-01-17 16:24:32","productTypeId":19},"infoId":56}],"freshShop":{"name":"季新杰","imageAvatar":"static/201901/ab17d1df-346a-4c77-bf6f-efdd31debbda.jpg","longitude":106.647033,"latitude":26.618785,"phoneNumberOfContact":"15086025037"},"orderPay":{"createTime":"2019-01-18 10:09:32","modifyTime":"2019-01-18 10:09:55","id":6,"serialNum":"201901181009319207ORDER_PAY","payType":"ALI_PAY","status":"PAY_SUCCESS","totalFee":1,"finalFee":1,"payResponse":"{\"gmt_create\":\"2019-01-18 10:09:53\",\"charset\":\"utf-8\",\"seller_email\":\"gnw@guinong360.com\",\"subject\":\"201901181009319207ORDER_PAY\",\"sign\":\"IRwm8J/kxEjawqyzGDJJM6sl24paQDeNUFtTl7ZVNBESoNnAkFpNfIrrqmh43Te0ykmXDqZMy06eMZj/5Q6G2BkQ2ojuqOBw4Z9Ir5C6Xpio8FZetYHFTUUleRTL23cARdfs8TzYBGG37T60Oib+jZtUJg/pNXGjgwg/Dz7D/J46AD+FeAxE/5cyi0gL109214oR3m0PQxVQHEc+REF+08rJX7NE/No6pSZnmVVMWJczU5ET6QH4S71Djx/fWXaxTO2wiL89w4ZS+zPMPR9TLx2JX80CXm8nQ7Njkv33P3cQFQGVoFyeCPY61eEHisULsC3JA7Ce0bqb4BQrzEZqYA==\",\"buyer_id\":\"2088112296446319\",\"invoice_amount\":\"0.01\",\"notify_id\":\"2019011800222100954046311033774462\",\"fund_bill_list\":\"[{\\\"amount\\\":\\\"0.01\\\",\\\"fundChannel\\\":\\\"ALIPAYACCOUNT\\\"}]\",\"notify_type\":\"trade_status_sync\",\"trade_status\":\"TRADE_SUCCESS\",\"receipt_amount\":\"0.01\",\"app_id\":\"2016060401480481\",\"buyer_pay_amount\":\"0.01\",\"sign_type\":\"RSA2\",\"seller_id\":\"2088121828701307\",\"gmt_payment\":\"2019-01-18 10:09:53\",\"notify_time\":\"2019-01-18 10:09:54\",\"version\":\"1.0\",\"out_trade_no\":\"201901181009319207ORDER_PAY\",\"total_amount\":\"0.01\",\"trade_no\":\"2019011822001446311010188991\",\"auth_app_id\":\"2016060401480481\",\"buyer_logon_id\":\"182****2993\",\"point_amount\":\"0.00\"}","payTime":"2019-01-18 10:09:55"},"account":{"createTime":"2019-01-17 17:30:30","modifyTime":"2019-01-17 17:30:30","id":42,"name":"","userId":1302,"phone":"18286882993"}}]
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
         * createTime : 2019-01-18 10:09:32
         * modifyTime : 2019-01-18 10:09:55
         * id : 56
         * serialNum : 2019011810093180460ORDER_INFO
         * status : WAITING_TAKE
         * address : {"id":6,"name":"王宇","phone":"18089697084","detail":"高新区高科国际西部国际软件园&大数据中心","userId":121,"latitude":26.618877,"location":"贵州省贵阳市观山湖区高新区高科国际西部国际软件园&大数据中心","longitude":106.646679,"createTime":"2019-01-16 09:44:26","modifyTime":"2019-01-16 09:44:26"}
         * totalNum : 1
         * totalFee : 1
         * sendFee : 0
         * finalFee : 1
         * taxFee : 0
         * packageFee : 0
         * remark :
         * cancelEndTime : 2019-01-18 10:29:32
         * distance : 0.0366474843960767
         * userId : 1302
         * payId : 6
         * shopId : 36
         * shopName : 季新杰
         * orderItemList : [{"createTime":"2019-01-18 10:09:32","modifyTime":"2019-01-18 10:09:32","id":99,"num":1,"product":{"id":51,"data":{"mainPic":"static/201901/8da5e2f1-1540-4b9a-9ccb-dff8c83c80f8.jpg"},"name":"测试商品","unit":"500kg","shopId":36,"status":"ENABLE","unitPrice":1,"createTime":"2019-01-17 16:24:32","modifyTime":"2019-01-17 16:24:32","productTypeId":19},"infoId":56}]
         * freshShop : {"name":"季新杰","imageAvatar":"static/201901/ab17d1df-346a-4c77-bf6f-efdd31debbda.jpg","longitude":106.647033,"latitude":26.618785,"phoneNumberOfContact":"15086025037"}
         * orderPay : {"createTime":"2019-01-18 10:09:32","modifyTime":"2019-01-18 10:09:55","id":6,"serialNum":"201901181009319207ORDER_PAY","payType":"ALI_PAY","status":"PAY_SUCCESS","totalFee":1,"finalFee":1,"payResponse":"{\"gmt_create\":\"2019-01-18 10:09:53\",\"charset\":\"utf-8\",\"seller_email\":\"gnw@guinong360.com\",\"subject\":\"201901181009319207ORDER_PAY\",\"sign\":\"IRwm8J/kxEjawqyzGDJJM6sl24paQDeNUFtTl7ZVNBESoNnAkFpNfIrrqmh43Te0ykmXDqZMy06eMZj/5Q6G2BkQ2ojuqOBw4Z9Ir5C6Xpio8FZetYHFTUUleRTL23cARdfs8TzYBGG37T60Oib+jZtUJg/pNXGjgwg/Dz7D/J46AD+FeAxE/5cyi0gL109214oR3m0PQxVQHEc+REF+08rJX7NE/No6pSZnmVVMWJczU5ET6QH4S71Djx/fWXaxTO2wiL89w4ZS+zPMPR9TLx2JX80CXm8nQ7Njkv33P3cQFQGVoFyeCPY61eEHisULsC3JA7Ce0bqb4BQrzEZqYA==\",\"buyer_id\":\"2088112296446319\",\"invoice_amount\":\"0.01\",\"notify_id\":\"2019011800222100954046311033774462\",\"fund_bill_list\":\"[{\\\"amount\\\":\\\"0.01\\\",\\\"fundChannel\\\":\\\"ALIPAYACCOUNT\\\"}]\",\"notify_type\":\"trade_status_sync\",\"trade_status\":\"TRADE_SUCCESS\",\"receipt_amount\":\"0.01\",\"app_id\":\"2016060401480481\",\"buyer_pay_amount\":\"0.01\",\"sign_type\":\"RSA2\",\"seller_id\":\"2088121828701307\",\"gmt_payment\":\"2019-01-18 10:09:53\",\"notify_time\":\"2019-01-18 10:09:54\",\"version\":\"1.0\",\"out_trade_no\":\"201901181009319207ORDER_PAY\",\"total_amount\":\"0.01\",\"trade_no\":\"2019011822001446311010188991\",\"auth_app_id\":\"2016060401480481\",\"buyer_logon_id\":\"182****2993\",\"point_amount\":\"0.00\"}","payTime":"2019-01-18 10:09:55"}
         * account : {"createTime":"2019-01-17 17:30:30","modifyTime":"2019-01-17 17:30:30","id":42,"name":"","userId":1302,"phone":"18286882993"}
         */

        private String createTime;
        private String modifyTime;
        private int id;
        private String serialNum;
        private String status;
        private AddressBean address;
        private int totalNum;
        private double totalFee;
        private double sendFee;
        private double finalFee;
        private double taxFee;
        private double packageFee;
        private String remark;
        private String cancelEndTime;
        private double distance;
        private int userId;
        private int payId;
        private int shopId;
        private String shopName;
        private FreshShopBean freshShop;
        private OrderPayBean orderPay;
        private AccountBean account;
        private OrdersDetailResponse.OrderRefund orderRefund;

        public OrdersDetailResponse.OrderRefund getOrderRefund() {
            return orderRefund;
        }

        public void setOrderRefund(OrdersDetailResponse.OrderRefund orderRefund) {
            this.orderRefund = orderRefund;
        }

        private List<OrderItemListBean> orderItemList;

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

        public String getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(String serialNum) {
            this.serialNum = serialNum;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public int getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(int totalNum) {
            this.totalNum = totalNum;
        }

        public double getTotalFee() {
            return totalFee;
        }

        public void setTotalFee(double totalFee) {
            this.totalFee = totalFee;
        }

        public double getSendFee() {
            return sendFee;
        }

        public void setSendFee(double sendFee) {
            this.sendFee = sendFee;
        }

        public double getFinalFee() {
            return finalFee;
        }

        public void setFinalFee(double finalFee) {
            this.finalFee = finalFee;
        }

        public double getTaxFee() {
            return taxFee;
        }

        public void setTaxFee(double taxFee) {
            this.taxFee = taxFee;
        }

        public double getPackageFee() {
            return packageFee;
        }

        public void setPackageFee(double packageFee) {
            this.packageFee = packageFee;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCancelEndTime() {
            return cancelEndTime;
        }

        public void setCancelEndTime(String cancelEndTime) {
            this.cancelEndTime = cancelEndTime;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getPayId() {
            return payId;
        }

        public void setPayId(int payId) {
            this.payId = payId;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public FreshShopBean getFreshShop() {
            return freshShop;
        }

        public void setFreshShop(FreshShopBean freshShop) {
            this.freshShop = freshShop;
        }

        public OrderPayBean getOrderPay() {
            return orderPay;
        }

        public void setOrderPay(OrderPayBean orderPay) {
            this.orderPay = orderPay;
        }

        public AccountBean getAccount() {
            return account;
        }

        public void setAccount(AccountBean account) {
            this.account = account;
        }

        public List<OrderItemListBean> getOrderItemList() {
            return orderItemList;
        }

        public void setOrderItemList(List<OrderItemListBean> orderItemList) {
            this.orderItemList = orderItemList;
        }

        public static class AddressBean implements Serializable {
            /**
             * id : 6
             * name : 王宇
             * phone : 18089697084
             * detail : 高新区高科国际西部国际软件园&大数据中心
             * userId : 121
             * latitude : 26.618877
             * location : 贵州省贵阳市观山湖区高新区高科国际西部国际软件园&大数据中心
             * longitude : 106.646679
             * createTime : 2019-01-16 09:44:26
             * modifyTime : 2019-01-16 09:44:26
             */

            private int id;
            private String name;
            private String phone;
            private String detail;
            private int userId;
            private double latitude;
            private String location;
            private double longitude;
            private String createTime;
            private String modifyTime;

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

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
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
        }

        public static class FreshShopBean implements Serializable {
            /**
             * name : 季新杰
             * imageAvatar : static/201901/ab17d1df-346a-4c77-bf6f-efdd31debbda.jpg
             * longitude : 106.647033
             * latitude : 26.618785
             * phoneNumberOfContact : 15086025037
             */

            private String name;
            private String imageAvatar;
            private double longitude;
            private double latitude;
            private String phoneNumberOfContact;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImageAvatar() {
                return imageAvatar;
            }

            public void setImageAvatar(String imageAvatar) {
                this.imageAvatar = imageAvatar;
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

            public String getPhoneNumberOfContact() {
                return phoneNumberOfContact;
            }

            public void setPhoneNumberOfContact(String phoneNumberOfContact) {
                this.phoneNumberOfContact = phoneNumberOfContact;
            }
        }

        public static class OrderPayBean implements Serializable {
            /**
             * createTime : 2019-01-18 10:09:32
             * modifyTime : 2019-01-18 10:09:55
             * id : 6
             * serialNum : 201901181009319207ORDER_PAY
             * payType : ALI_PAY
             * status : PAY_SUCCESS
             * totalFee : 1
             * finalFee : 1
             * payResponse : {"gmt_create":"2019-01-18 10:09:53","charset":"utf-8","seller_email":"gnw@guinong360.com","subject":"201901181009319207ORDER_PAY","sign":"IRwm8J/kxEjawqyzGDJJM6sl24paQDeNUFtTl7ZVNBESoNnAkFpNfIrrqmh43Te0ykmXDqZMy06eMZj/5Q6G2BkQ2ojuqOBw4Z9Ir5C6Xpio8FZetYHFTUUleRTL23cARdfs8TzYBGG37T60Oib+jZtUJg/pNXGjgwg/Dz7D/J46AD+FeAxE/5cyi0gL109214oR3m0PQxVQHEc+REF+08rJX7NE/No6pSZnmVVMWJczU5ET6QH4S71Djx/fWXaxTO2wiL89w4ZS+zPMPR9TLx2JX80CXm8nQ7Njkv33P3cQFQGVoFyeCPY61eEHisULsC3JA7Ce0bqb4BQrzEZqYA==","buyer_id":"2088112296446319","invoice_amount":"0.01","notify_id":"2019011800222100954046311033774462","fund_bill_list":"[{\"amount\":\"0.01\",\"fundChannel\":\"ALIPAYACCOUNT\"}]","notify_type":"trade_status_sync","trade_status":"TRADE_SUCCESS","receipt_amount":"0.01","app_id":"2016060401480481","buyer_pay_amount":"0.01","sign_type":"RSA2","seller_id":"2088121828701307","gmt_payment":"2019-01-18 10:09:53","notify_time":"2019-01-18 10:09:54","version":"1.0","out_trade_no":"201901181009319207ORDER_PAY","total_amount":"0.01","trade_no":"2019011822001446311010188991","auth_app_id":"2016060401480481","buyer_logon_id":"182****2993","point_amount":"0.00"}
             * payTime : 2019-01-18 10:09:55
             */

            private String createTime;
            private String modifyTime;
            private int id;
            private String serialNum;
            private String payType;
            private String status;
            private int totalFee;
            private int finalFee;
            private String payResponse;
            private String payTime;

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

            public String getSerialNum() {
                return serialNum;
            }

            public void setSerialNum(String serialNum) {
                this.serialNum = serialNum;
            }

            public String getPayType() {
                return payType;
            }

            public void setPayType(String payType) {
                this.payType = payType;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getTotalFee() {
                return totalFee;
            }

            public void setTotalFee(int totalFee) {
                this.totalFee = totalFee;
            }

            public int getFinalFee() {
                return finalFee;
            }

            public void setFinalFee(int finalFee) {
                this.finalFee = finalFee;
            }

            public String getPayResponse() {
                return payResponse;
            }

            public void setPayResponse(String payResponse) {
                this.payResponse = payResponse;
            }

            public String getPayTime() {
                return payTime;
            }

            public void setPayTime(String payTime) {
                this.payTime = payTime;
            }
        }

        public static class AccountBean implements Serializable {
            /**
             * createTime : 2019-01-17 17:30:30
             * modifyTime : 2019-01-17 17:30:30
             * id : 42
             * name :
             * userId : 1302
             * phone : 18286882993
             */

            private String createTime;
            private String modifyTime;
            private int id;
            private String name;
            private int userId;
            private String phone;

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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }

        public static class OrderItemListBean implements Serializable {
            /**
             * createTime : 2019-01-18 10:09:32
             * modifyTime : 2019-01-18 10:09:32
             * id : 99
             * num : 1
             * product : {"id":51,"data":{"mainPic":"static/201901/8da5e2f1-1540-4b9a-9ccb-dff8c83c80f8.jpg"},"name":"测试商品","unit":"500kg","shopId":36,"status":"ENABLE","unitPrice":1,"createTime":"2019-01-17 16:24:32","modifyTime":"2019-01-17 16:24:32","productTypeId":19}
             * infoId : 56
             */

            private String createTime;
            private String modifyTime;
            private int id;
            private int num;
            private ProductBean product;
            private int infoId;

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

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public ProductBean getProduct() {
                return product;
            }

            public void setProduct(ProductBean product) {
                this.product = product;
            }

            public int getInfoId() {
                return infoId;
            }

            public void setInfoId(int infoId) {
                this.infoId = infoId;
            }

            public static class ProductBean implements Serializable {
                /**
                 * id : 51
                 * data : {"mainPic":"static/201901/8da5e2f1-1540-4b9a-9ccb-dff8c83c80f8.jpg"}
                 * name : 测试商品
                 * unit : 500kg
                 * shopId : 36
                 * status : ENABLE
                 * unitPrice : 1
                 * createTime : 2019-01-17 16:24:32
                 * modifyTime : 2019-01-17 16:24:32
                 * productTypeId : 19
                 */

                private int id;
                private DataBean data;
                private String name;
                private String unit;
                private int shopId;
                private String status;
                private double unitPrice;
                private String createTime;
                private String modifyTime;
                private int productTypeId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public DataBean getData() {
                    return data;
                }

                public void setData(DataBean data) {
                    this.data = data;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
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

                public double getUnitPrice() {
                    return unitPrice;
                }

                public void setUnitPrice(double unitPrice) {
                    this.unitPrice = unitPrice;
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

                public int getProductTypeId() {
                    return productTypeId;
                }

                public void setProductTypeId(int productTypeId) {
                    this.productTypeId = productTypeId;
                }

                public static class DataBean implements Serializable {
                    /**
                     * mainPic : static/201901/8da5e2f1-1540-4b9a-9ccb-dff8c83c80f8.jpg
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
    }
}
