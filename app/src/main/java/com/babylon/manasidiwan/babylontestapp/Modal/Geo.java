package com.babylon.manasidiwan.babylontestapp.Modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manasidiwan on 02/08/2016.
 */
public class Geo implements Serializable {

    @SerializedName("lat")
    private String mLatitude;
    @SerializedName("lng")
    private String mLongitude;

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String lat) {
        this.mLatitude = lat;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String lng) {
        this.mLongitude = lng;
    }
}
