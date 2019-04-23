package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangyu
 * @time 2017/8/1 0001 on 下午 14:40
 * @desc
 */
public class OrdersDetailResponse implements Serializable {

    /**
     * createTime : 2019-01-21 15:14:21
     * modifyTime : 2019-01-21 15:14:35
     * id : 96
     * serialNum : 2019012115142111994ORDER_INFO
     * status : WAITING_TAKE
     * address : {"id":9,"name":"jack","phone":"128286883106","detail":"street 23","userId":67,"latitude":26.62,"location":"贵阳市观山湖区高科一号","longitude":106.65,"createTime":"2019-01-16 17:15:46","modifyTime":"2019-01-16 17:15:46"}
     * totalNum : 2
     * totalFee : 2
     * sendFee : 0
     * finalFee : 2
     * taxFee : 0
     * packageFee : 0
     * remark : 刚回家
     * cancelEndTime : 2019-01-21 15:34:21
     * distance : 0.32441512498771413
     * userId : 67
     * payId : 60
     * shopId : 36
     * shopName : 季新杰
     * orderItemList : [{"createTime":"2019-01-21 15:14:21","modifyTime":"2019-01-21 15:14:21","id":160,"num":1,"product":{"id":51,"data":{"mainPic":"static/201901/8da5e2f1-1540-4b9a-9ccb-dff8c83c80f8.jpg"},"name":"测试商品","unit":"500kg","shopId":36,"status":"ENABLE","unitPrice":1,"createTime":"2019-01-17 16:24:32","modifyTime":"2019-01-17 16:24:32","productTypeId":19},"infoId":96},{"createTime":"2019-01-21 15:14:21","modifyTime":"2019-01-21 15:14:21","id":161,"num":1,"product":{"id":52,"data":{"mainPic":"static/201901/43c981f4-a957-4ece-8c5e-6f24e971adf1.jpg"},"name":"测试2","unit":"500g","shopId":36,"status":"ENABLE","unitPrice":1,"createTime":"2019-01-17 16:28:57","modifyTime":"2019-01-17 16:28:57","productTypeId":19},"infoId":96}]
     * freshShop : {"name":"季新杰","imageAvatar":"static/201901/ab17d1df-346a-4c77-bf6f-efdd31debbda.jpg","longitude":106.647033,"latitude":26.618785,"phoneNumberOfContact":"15086025037"}
     * orderPay : {"createTime":"2019-01-21 15:14:22","modifyTime":"2019-01-21 15:14:35","id":60,"serialNum":"2019012115142126150ORDER_PAY","payType":"WX_PAY","status":"PAY_SUCCESS","totalFee":2,"finalFee":2,"payResponse":"<xml><appid><![CDATA[wx5e3f5b903e71e540]]><\/appid><bank_type><![CDATA[CFT]]><\/bank_type><cash_fee><![CDATA[2]]><\/cash_fee><fee_type><![CDATA[CNY]]><\/fee_type><is_subscribe><![CDATA[N]]><\/is_subscribe><mch_id><![CDATA[1480178632]]><\/mch_id><nonce_str><![CDATA[a411088765a847afa106813648c35c73]]><\/nonce_str><openid><![CDATA[oW86ev60sm7Hw9xA8w4aFLFIZKFE]]><\/openid><out_trade_no><![CDATA[2019012115142126150ORDER_PAY]]><\/out_trade_no><result_code><![CDATA[SUCCESS]]><\/result_code><return_code><![CDATA[SUCCESS]]><\/return_code><sign><![CDATA[D151A9BD94313D2D2D03461AAE0FB257]]><\/sign><time_end><![CDATA[20190121151434]]><\/time_end><total_fee>2<\/total_fee><trade_type><![CDATA[APP]]><\/trade_type><transaction_id><![CDATA[4200000286201901213717699759]]><\/transaction_id><\/xml>","payTime":"2019-01-21 15:14:35"}
     * account : {"createTime":"2019-01-09 20:13:43","modifyTime":"2019-01-09 20:13:43","id":18,"name":"18286883106","userId":67,"phone":"18286883106"}
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
    private List<OrderItemListBean> orderItemList;
    private OrderRefund orderRefund;

    public OrderRefund getOrderRefund() {
        return orderRefund;
    }

    public void setOrderRefund(OrderRefund orderRefund) {
        this.orderRefund = orderRefund;
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

    public static class OrderRefund implements Serializable {
        /**
         * createTime : 2019-01-21 17:08:07
         * modifyTime : 2019-01-21 17:08:08
         * id : 23
         * serialNum : 2019012117080653724ORDER_REFUND
         * finalFee : 1
         * reason : 商家取消订单
         * status : SUCCESS
         * type : SYSTEMT
         * handleTime : 2019-01-21 17:08:08
         * refundData : {"alipay_trade_refund_response":{"code":"10000","msg":"Success","buyer_logon_id":"182******93","buyer_user_id":"2088112296446319","fund_change":"Y","gmt_refund_pay":"2019-01-21 17:08:07","out_trade_no":"2019012117070651261ORDER_PAY","refund_fee":"0.01","send_back_fee":"0.00","trade_no":"2019012122001446311011152344"},"sign":"OSon4TmFU2mBX3ZJvMJUjUuUuq3krq2AWIHHfj9ZjKKQ6zM7FK4boKnTI74cLfnt429YmI/7dw7ZXGx0qZWBtbyYOOIUwo0CGmLjfkPUneAM3XbKwLabJ0WsWB+joNLsB/Eyc6rdjXy3qfWpAMM0ZLIMBE9aGKVvugHzqf7Qqdpuzw6ojNqQta84FiHbJRQUhgVCFoOG7IoU3edGoZJcZ8wXi1eGQpfHgusjgNDYP83KFBY3T8VtuJ6uBkox0gsZPBoEA8DxlCjg95hERP+0LlTaf8lFhO/DwzTxsjJaVUhk6EUfoZUBK7DQ0vTn9Vr3GArgpKaiYzqfT54N8ExUhw=="}
         * infoId : 107
         * userId : 1302
         * shopId : 32
         */

        private String createTime;
        private String modifyTime;
        private int id;
        private String serialNum;
        private int finalFee;
        private String reason;
        private String status;
        private String type;
        private String handleTime;
        private String refundData;
        private int infoId;
        private int userId;
        private int shopId;

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

        public int getFinalFee() {
            return finalFee;
        }

        public void setFinalFee(int finalFee) {
            this.finalFee = finalFee;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getHandleTime() {
            return handleTime;
        }

        public void setHandleTime(String handleTime) {
            this.handleTime = handleTime;
        }

        public String getRefundData() {
            return refundData;
        }

        public void setRefundData(String refundData) {
            this.refundData = refundData;
        }

        public int getInfoId() {
            return infoId;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }
    }

    public static class AddressBean implements Serializable {
        /**
         * id : 9
         * name : jack
         * phone : 128286883106
         * detail : street 23
         * userId : 67
         * latitude : 26.62
         * location : 贵阳市观山湖区高科一号
         * longitude : 106.65
         * createTime : 2019-01-16 17:15:46
         * modifyTime : 2019-01-16 17:15:46
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
         * createTime : 2019-01-21 15:14:22
         * modifyTime : 2019-01-21 15:14:35
         * id : 60
         * serialNum : 2019012115142126150ORDER_PAY
         * payType : WX_PAY
         * status : PAY_SUCCESS
         * totalFee : 2
         * finalFee : 2
         * payResponse : <xml><appid><![CDATA[wx5e3f5b903e71e540]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[2]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[1480178632]]></mch_id><nonce_str><![CDATA[a411088765a847afa106813648c35c73]]></nonce_str><openid><![CDATA[oW86ev60sm7Hw9xA8w4aFLFIZKFE]]></openid><out_trade_no><![CDATA[2019012115142126150ORDER_PAY]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[D151A9BD94313D2D2D03461AAE0FB257]]></sign><time_end><![CDATA[20190121151434]]></time_end><total_fee>2</total_fee><trade_type><![CDATA[APP]]></trade_type><transaction_id><![CDATA[4200000286201901213717699759]]></transaction_id></xml>
         * payTime : 2019-01-21 15:14:35
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
         * createTime : 2019-01-09 20:13:43
         * modifyTime : 2019-01-09 20:13:43
         * id : 18
         * name : 18286883106
         * userId : 67
         * phone : 18286883106
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
         * createTime : 2019-01-21 15:14:21
         * modifyTime : 2019-01-21 15:14:21
         * id : 160
         * num : 1
         * product : {"id":51,"data":{"mainPic":"static/201901/8da5e2f1-1540-4b9a-9ccb-dff8c83c80f8.jpg"},"name":"测试商品","unit":"500kg","shopId":36,"status":"ENABLE","unitPrice":1,"createTime":"2019-01-17 16:24:32","modifyTime":"2019-01-17 16:24:32","productTypeId":19}
         * infoId : 96
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
            private int unitPrice;
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

            public int getUnitPrice() {
                return unitPrice;
            }

            public void setUnitPrice(int unitPrice) {
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