package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class UpdateUserRequest implements Serializable {

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
     * rangeOfSend : 2
     */

    private int id;
    private int userId;
    private String imageAvatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
