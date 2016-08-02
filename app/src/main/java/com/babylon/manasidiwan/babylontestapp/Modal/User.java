package com.babylon.manasidiwan.babylontestapp.Modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author manasidiwan
 */
public class User implements Serializable {

    @SerializedName("id")
    private long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("username")
    private String mUserName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("address")
    private Address mAddress;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("website")
    private String mWebsite;
    @SerializedName("company")
    private Company mCompany;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        this.mUserName = userName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        this.mPhone = phone;
    }

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        this.mAddress = address;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        this.mWebsite = website;
    }

    public Company getCompany() {
        return mCompany;
    }

    public void setCompany(Company company) {
        this.mCompany = company;
    }
}
