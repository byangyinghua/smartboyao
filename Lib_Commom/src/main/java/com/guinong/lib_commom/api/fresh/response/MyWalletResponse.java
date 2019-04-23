package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;
import java.util.List;

public class MyWalletResponse implements Serializable {

    /**
     * createTime : 2018-12-29 17:56:22
     * modifyTime : 2019-01-02 10:10:23
     * id : 1
     * total : 188
     * userId : 70037
     * expectIncome : 906
     * accumulativeIncome : 1294
     * childrenCount : 4
     * applyWithdrawCount : 2
     * withdrawConfig : {"unit":"WEEK","dayList":[2,6],"minFee":5000,"time":null}
     */

    private String createTime;
    private String modifyTime;
    private int id;
    private double total;
    private int userId;
    private int expectIncome;
    private int accumulativeIncome;
    private int childrenCount;
    private int applyWithdrawCount;
    private WithdrawConfigBean withdrawConfig;

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExpectIncome() {
        return expectIncome;
    }

    public void setExpectIncome(int expectIncome) {
        this.expectIncome = expectIncome;
    }

    public int getAccumulativeIncome() {
        return accumulativeIncome;
    }

    public void setAccumulativeIncome(int accumulativeIncome) {
        this.accumulativeIncome = accumulativeIncome;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public int getApplyWithdrawCount() {
        return applyWithdrawCount;
    }

    public void setApplyWithdrawCount(int applyWithdrawCount) {
        this.applyWithdrawCount = applyWithdrawCount;
    }

    public WithdrawConfigBean getWithdrawConfig() {
        return withdrawConfig;
    }

    public void setWithdrawConfig(WithdrawConfigBean withdrawConfig) {
        this.withdrawConfig = withdrawConfig;
    }

    public static class WithdrawConfigBean implements Serializable {
        /**
         * unit : WEEK
         * dayList : [2,6]
         * minFee : 5000
         * time : null
         */

        private String unit;
        private int minFee;
        private int time;
        private List<Integer> dayList;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getMinFee() {
            return minFee;
        }

        public void setMinFee(int minFee) {
            this.minFee = minFee;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public List<Integer> getDayList() {
            return dayList;
        }

        public void setDayList(List<Integer> dayList) {
            this.dayList = dayList;
        }
    }
}
