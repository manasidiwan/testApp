package com.babylon.manasidiwan.babylontestapp.Modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author manasidiwan
 */
public class Post implements Serializable{

    @SerializedName("userId")
    private long mUserId;
    @SerializedName("id")
    private long mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("body")
    private String mBody;

    public long getUserId() {
        return mUserId;
    }

    public void setUserId(long userId) {
        this.mUserId = userId;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        this.mBody = body;
    }
}
