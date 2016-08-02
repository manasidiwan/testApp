package com.babylon.manasidiwan.babylontestapp.Modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manasidiwan on 02/08/2016.
 */
public class Address implements Serializable {

    @SerializedName("street")
    private String mStreet;
    @SerializedName("suite")
    private String mSuite;
    @SerializedName("city")
    private String mCity;
    @SerializedName("zipcode")
    private String mZipcode;
    @SerializedName("geo")
    private Geo mGeo;

    public void setStreet(String street) {
        this.mStreet = street;
    }

    public String getStreet() {
        return mStreet;
    }

    public void setSuite(String suite) {
        this.mSuite = suite;
    }

    public String getSuite() {
        return mSuite;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        this.mCity = city;
    }

    public String getZipcode() {
        return mZipcode;
    }

    public void setZipcode(String zipcode) {
        this.mZipcode = zipcode;
    }

    public Geo getGeo() {
        return mGeo;
    }

    public void setGeo(Geo geo) {
        this.mGeo = geo;
    }

}
