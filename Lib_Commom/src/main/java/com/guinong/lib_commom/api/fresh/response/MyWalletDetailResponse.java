package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;
import java.util.List;

public class MyWalletDetailResponse implements Serializable {


    /**
     * walletStatistics : [{"income":388,"month":"2018-12","outcome":null}]
     * walletPage : {"total":7,"current":1,"list":[{"createTime":"2018-12-29 17:55:45","modifyTime":"2018-12-29 17:56:32","id":7,"serialNum":"20181229175544963108WALLET","title":"收益","successTime":"2018-12-29 17:56:32","status":"SUCCESS","type":"IN","fee":106,"remainFee":388,"platformFee":3444,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170129024016986_ORDER_ITEM46369","infoSerial":"20170129024016986_ORDER_INFO46369"},{"createTime":"2018-12-29 17:55:44","modifyTime":"2018-12-29 17:56:30","id":6,"serialNum":"20181229175543781107WALLET","title":"收益","successTime":"2018-12-29 17:56:30","status":"SUCCESS","type":"IN","fee":29,"remainFee":282,"platformFee":956,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170123105131752_ORDER_ITEM37108","infoSerial":"20170123105131752_ORDER_INFO37108"},{"createTime":"2018-12-29 17:55:43","modifyTime":"2018-12-29 17:56:28","id":5,"serialNum":"20181229175542640106WALLET","title":"收益","successTime":"2018-12-29 17:56:28","status":"SUCCESS","type":"IN","fee":46,"remainFee":253,"platformFee":1514,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170117190008136_ORDER_ITEM27844","infoSerial":"20170117190008136_ORDER_INFO27844"},{"createTime":"2018-12-29 17:55:42","modifyTime":"2018-12-29 17:56:27","id":4,"serialNum":"20181229175541504105WALLET","title":"收益","successTime":"2018-12-29 17:56:27","status":"SUCCESS","type":"IN","fee":65,"remainFee":207,"platformFee":2115,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170112102841520_ORDER_ITEM19080","infoSerial":"20170112102841520_ORDER_INFO19080"},{"createTime":"2018-12-29 17:55:40","modifyTime":"2018-12-29 17:56:25","id":3,"serialNum":"20181229175540355104WALLET","title":"收益","successTime":"2018-12-29 17:56:25","status":"SUCCESS","type":"IN","fee":58,"remainFee":142,"platformFee":1882,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170109191155410_ORDER_ITEM14765","infoSerial":"20170109191155410_ORDER_INFO14765"},{"createTime":"2018-12-29 17:55:39","modifyTime":"2018-12-29 17:56:24","id":2,"serialNum":"20181229175539147103WALLET","title":"收益","successTime":"2018-12-29 17:56:24","status":"SUCCESS","type":"IN","fee":37,"remainFee":84,"platformFee":1203,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170108112934782_ORDER_ITEM12603","infoSerial":"20170108112934782_ORDER_INFO12603"},{"createTime":"2018-12-29 17:55:38","modifyTime":"2018-12-29 17:56:22","id":1,"serialNum":"20181229175537994102WALLET","title":"收益","successTime":"2018-12-29 17:56:22","status":"SUCCESS","type":"IN","fee":47,"remainFee":47,"platformFee":1533,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170106153655134_ORDER_ITEM9611","infoSerial":"20170106153655134_ORDER_INFO9611"}]}
     */

    private WalletPageBean walletPage;
    private List<WalletStatisticsBean> walletStatistics;

    public WalletPageBean getWalletPage() {
        return walletPage;
    }

    public void setWalletPage(WalletPageBean walletPage) {
        this.walletPage = walletPage;
    }

    public List<WalletStatisticsBean> getWalletStatistics() {
        return walletStatistics;
    }

    public void setWalletStatistics(List<WalletStatisticsBean> walletStatistics) {
        this.walletStatistics = walletStatistics;
    }

    public static class WalletPageBean implements Serializable {
        /**
         * total : 7
         * current : 1
         * list : [{"createTime":"2018-12-29 17:55:45","modifyTime":"2018-12-29 17:56:32","id":7,"serialNum":"20181229175544963108WALLET","title":"收益","successTime":"2018-12-29 17:56:32","status":"SUCCESS","type":"IN","fee":106,"remainFee":388,"platformFee":3444,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170129024016986_ORDER_ITEM46369","infoSerial":"20170129024016986_ORDER_INFO46369"},{"createTime":"2018-12-29 17:55:44","modifyTime":"2018-12-29 17:56:30","id":6,"serialNum":"20181229175543781107WALLET","title":"收益","successTime":"2018-12-29 17:56:30","status":"SUCCESS","type":"IN","fee":29,"remainFee":282,"platformFee":956,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170123105131752_ORDER_ITEM37108","infoSerial":"20170123105131752_ORDER_INFO37108"},{"createTime":"2018-12-29 17:55:43","modifyTime":"2018-12-29 17:56:28","id":5,"serialNum":"20181229175542640106WALLET","title":"收益","successTime":"2018-12-29 17:56:28","status":"SUCCESS","type":"IN","fee":46,"remainFee":253,"platformFee":1514,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170117190008136_ORDER_ITEM27844","infoSerial":"20170117190008136_ORDER_INFO27844"},{"createTime":"2018-12-29 17:55:42","modifyTime":"2018-12-29 17:56:27","id":4,"serialNum":"20181229175541504105WALLET","title":"收益","successTime":"2018-12-29 17:56:27","status":"SUCCESS","type":"IN","fee":65,"remainFee":207,"platformFee":2115,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170112102841520_ORDER_ITEM19080","infoSerial":"20170112102841520_ORDER_INFO19080"},{"createTime":"2018-12-29 17:55:40","modifyTime":"2018-12-29 17:56:25","id":3,"serialNum":"20181229175540355104WALLET","title":"收益","successTime":"2018-12-29 17:56:25","status":"SUCCESS","type":"IN","fee":58,"remainFee":142,"platformFee":1882,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170109191155410_ORDER_ITEM14765","infoSerial":"20170109191155410_ORDER_INFO14765"},{"createTime":"2018-12-29 17:55:39","modifyTime":"2018-12-29 17:56:24","id":2,"serialNum":"20181229175539147103WALLET","title":"收益","successTime":"2018-12-29 17:56:24","status":"SUCCESS","type":"IN","fee":37,"remainFee":84,"platformFee":1203,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170108112934782_ORDER_ITEM12603","infoSerial":"20170108112934782_ORDER_INFO12603"},{"createTime":"2018-12-29 17:55:38","modifyTime":"2018-12-29 17:56:22","id":1,"serialNum":"20181229175537994102WALLET","title":"收益","successTime":"2018-12-29 17:56:22","status":"SUCCESS","type":"IN","fee":47,"remainFee":47,"platformFee":1533,"remark":"13339678666购买商品，您获得奖励","userId":70037,"itemSerial":"20170106153655134_ORDER_ITEM9611","infoSerial":"20170106153655134_ORDER_INFO9611"}]
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

        public static class ListBean {
            /**
             * createTime : 2018-12-29 17:55:45
             * modifyTime : 2018-12-29 17:56:32
             * id : 7
             * serialNum : 20181229175544963108WALLET
             * title : 收益
             * successTime : 2018-12-29 17:56:32
             * status : SUCCESS
             * type : IN
             * fee : 106
             * remainFee : 388
             * platformFee : 3444
             * remark : 13339678666购买商品，您获得奖励
             * userId : 70037
             * itemSerial : 20170129024016986_ORDER_ITEM46369
             * infoSerial : 20170129024016986_ORDER_INFO46369
             */

            private String createTime;
            private String modifyTime;
            private int id;
            private String serialNum;
            private String title;
            private String successTime;
            private String status;
            private String type;
            private double fee;
            private double remainFee;
            private int platformFee;
            private String remark;
            private int userId;
            private String itemSerial;
            private String infoSerial;
            private double income;
            private String month;
            private double outcome;
            private int postion;

            public int getPostion() {
                return postion;
            }

            public void setPostion(int postion) {
                this.postion = postion;
            }

            public double getIncome() {
                return income;
            }

            public void setIncome(double income) {
                this.income = income;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public double getOutcome() {
                return outcome;
            }

            public void setOutcome(double outcome) {
                this.outcome = outcome;
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSuccessTime() {
                return successTime;
            }

            public void setSuccessTime(String successTime) {
                this.successTime = successTime;
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

            public double getFee() {
                return fee;
            }

            public void setFee(double fee) {
                this.fee = fee;
            }

            public double getRemainFee() {
                return remainFee;
            }

            public void setRemainFee(double remainFee) {
                this.remainFee = remainFee;
            }

            public int getPlatformFee() {
                return platformFee;
            }

            public void setPlatformFee(int platformFee) {
                this.platformFee = platformFee;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getItemSerial() {
                return itemSerial;
            }

            public void setItemSerial(String itemSerial) {
                this.itemSerial = itemSerial;
            }

            public String getInfoSerial() {
                return infoSerial;
            }

            public void setInfoSerial(String infoSerial) {
                this.infoSerial = infoSerial;
            }
        }
    }

    public static class WalletStatisticsBean implements Serializable {
        /**
         * income : 388
         * month : 2018-12
         * outcome : null
         */

        private double income;
        private String month;
        private double outcome;

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public double getOutcome() {
            return outcome;
        }

        public void setOutcome(double outcome) {
            this.outcome = outcome;
        }
    }
}
