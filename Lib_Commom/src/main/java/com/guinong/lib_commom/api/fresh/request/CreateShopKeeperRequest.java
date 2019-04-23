package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class CreateShopKeeperRequest implements Serializable {

    /**
     * id : 1000
     * userId : 10004
     * openTime : 09:00:00
     * closeTime : 21:00:00
     * name : 蔬菜店
     * imageAvatar : ['a.png', 'b.png']
     * imageShop : ['c.png', 'd.png']
     * longitude : 109.12389201
     * latitude : 25.102321
     * address : 贵阳市观山湖区
     * photoFrontOfIdCard : 身份证正面照片.png
     * photoBehindOfIdCard : 身份证反面照片.png
     * photoBusinessLicense : 营业执照.png
     * realNameOfContact : 联系人真实姓名
     * phoneNumberOfContact : 联系人电话
     * status : WAIT_AUDIT
     * statusStr : 当状态异常（冻结，审核拒绝）时，必须传此参数
     * sendFee : 100
     * lowestTotalFee : 2500
     * packageFee : 100
     * idCardNumber : 110102199909011102
     */

    private Long id;
    private int userId;
    private String openTime;
    private String closeTime;
    private String name;
    private String imageAvatar;
    private String imageShop;
    private double longitude;
    private double latitude;
    private String address;
    private String photoFrontOfIdCard;
    private String photoBehindOfIdCard;
    private String photoBusinessLicense;
    private String realNameOfContact;
    private String phoneNumberOfContact;
    private String status;
    private String statusStr;
    private int sendFee;
    private int lowestTotalFee;
    private int packageFee;
    private String idCardNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getImageShop() {
        return imageShop;
    }

    public void setImageShop(String imageShop) {
        this.imageShop = imageShop;
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

    public int getSendFee() {
        return sendFee;
    }

    public void setSendFee(int sendFee) {
        this.sendFee = sendFee;
    }

    public int getLowestTotalFee() {
        return lowestTotalFee;
    }

    public void setLowestTotalFee(int lowestTotalFee) {
        this.lowestTotalFee = lowestTotalFee;
    }

    public int getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(int packageFee) {
        this.packageFee = packageFee;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }
}
