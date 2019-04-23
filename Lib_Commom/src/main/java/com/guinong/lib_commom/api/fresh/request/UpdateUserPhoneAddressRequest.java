package com.guinong.lib_commom.api.fresh.request;

import java.io.Serializable;

public class UpdateUserPhoneAddressRequest implements Serializable {

    private int id;
    private int userId;
    private String address;
    private String phoneNumberOfContact;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumberOfContact() {
        return phoneNumberOfContact;
    }

    public void setPhoneNumberOfContact(String phoneNumberOfContact) {
        this.phoneNumberOfContact = phoneNumberOfContact;
    }
}
