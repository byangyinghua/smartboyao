package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;

public class UserDataResponse implements Serializable {

    /**
     * createTime : 2019-01-11 18:12:39
     * modifyTime : 2019-01-11 18:19:28
     * id : 32
     * name : 554
     * userId : 1000017
     * imageAvatar : static/201901/db724fd9-45a4-4052-a887-515103eac2e7.jpg
     * longitude : 106.646712
     * latitude : 26.618872
     * address : 贵州省贵阳市观山湖区金岭社区服务中心长岭南路158号高科一号  吞吞吐吐
     * idCardNumber : 3455
     * photoFrontOfIdCard : static/201901/5b6e7252-ac86-47bb-8549-e7b1829a239d.jpg
     * photoBehindOfIdCard : static/201901/d5c26789-872f-4085-9771-65dc02d92885.jpg
     * photoBusinessLicense : static/201901/89006344-23a8-4194-86e3-87dac8c989fa.jpg
     * realNameOfContact : 4444
     * phoneNumberOfContact : 18286882993
     * status : ENABLE
     * statusStr : 第二次拒绝
     * sendFee : 0
     * lowestTotalFee : 0
     * packageFee : 0
     * rangeOfSend : 2
     */
    private int refundOrderCount;
    private int waitingPayOrderCount;
    private String createTime;
    private String modifyTime;
    private String openTime;
    private String closeTime;
    private int id;
    private String name;
    private boolean feeSetup;
    private int userId;
    private String imageAvatar;
    private String imageShop;
    private double longitude;
    private double latitude;
    private String address;
    private String idCardNumber;
    private String photoFrontOfIdCard;
    private String photoBehindOfIdCard;
    private String photoBusinessLicense;
    private String realNameOfContact;
    private String phoneNumberOfContact;
    private String status;
    private String statusStr;
    private Double sendFee;
    private Double lowestTotalFee;
    private Double packageFee;
    private Double rangeOfSend;
    private String alipayRealName;
    private String alipayAccount;
    private boolean alipaySetup;
    private String printerId;//打印机编号
    private String printerSecret;//打印机秘钥

    public String getPrinterId() {
        return printerId;
    }

    public void setPrinterId(String printerId) {
        this.printerId = printerId;
    }

    public String getPrinterSecret() {
        return printerSecret;
    }

    public void setPrinterSecret(String printerSecret) {
        this.printerSecret = printerSecret;
    }

    public boolean isFeeSetup() {
        return feeSetup;
    }

    public void setFeeSetup(boolean feeSetup) {
        this.feeSetup = feeSetup;
    }

    public String getAlipayRealName() {
        return alipayRealName;
    }

    public void setAlipayRealName(String alipayRealName) {
        this.alipayRealName = alipayRealName;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public boolean isAlipaySetup() {
        return alipaySetup;
    }

    public void setAlipaySetup(boolean alipaySetup) {
        this.alipaySetup = alipaySetup;
    }

    public int getRefundOrderCount() {
        return refundOrderCount;
    }

    public void setRefundOrderCount(int refundOrderCount) {
        this.refundOrderCount = refundOrderCount;
    }

    public int getWaitingPayOrderCount() {
        return waitingPayOrderCount;
    }

    public void setWaitingPayOrderCount(int waitingPayOrderCount) {
        this.waitingPayOrderCount = waitingPayOrderCount;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getImageShop() {
        return imageShop;
    }

    public void setImageShop(String imageShop) {
        this.imageShop = imageShop;
    }

    public Double getSendFee() {
        return sendFee;
    }

    public void setSendFee(Double sendFee) {
        this.sendFee = sendFee;
    }

    public Double getLowestTotalFee() {
        return lowestTotalFee;
    }

    public void setLowestTotalFee(Double lowestTotalFee) {
        this.lowestTotalFee = lowestTotalFee;
    }

    public Double getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(Double packageFee) {
        this.packageFee = packageFee;
    }

    public Double getRangeOfSend() {
        return rangeOfSend;
    }

    public void setRangeOfSend(Double rangeOfSend) {
        this.rangeOfSend = rangeOfSend;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPhotoFrontOfIdCard() {
        return photoFrontOfIdCard;
    }

    public void setPhotoFrontOfIdCard(String photoFrontOfIdCard) {
        this.photoFrontOfIdCard = photoFrontOfIdCard;
    }

    public String getPhotoBehindOfIdCard() {
        return photoBehindOfIdCard;
    }

    public void setPhotoBehindOfIdCard(String photoBehindOfIdCard) {
        this.photoBehindOfIdCard = photoBehindOfIdCard;
    }

    public String getPhotoBusinessLicense() {
        return photoBusinessLicense;
    }

    public void setPhotoBusinessLicense(String photoBusinessLicense) {
        this.photoBusinessLicense = photoBusinessLicense;
    }

    public String getRealNameOfContact() {
        return realNameOfContact;
    }

    public void setRealNameOfContact(String realNameOfContact) {
        this.realNameOfContact = realNameOfContact;
    }

    public String getPhoneNumberOfContact() {
        return phoneNumberOfContact;
    }

    public void setPhoneNumberOfContact(String phoneNumberOfContact) {
        this.phoneNumberOfContact = phoneNumberOfContact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }


}
