package com.guinong.lib_commom.api.fresh.response;

import java.io.Serializable;

/**
 * Created by wangyu on 2019/1/11 0011.
 */

public class FreshAddressResponse implements Serializable{


    /**
     * userId : 1302
     * id : 0
     * name : 李四
     * phone : 156465452
     * location : 贵州省贵阳市高新区百挑路
     * detail : 高科一号c栋22
     * longitude : 26.666
     * latitude : 106.56012
     */

    private int userId;
    private int id;
    private String name;
    private String phone;
    private String location;
    private String detail;
    private double longitude;
    private double latitude;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
}
