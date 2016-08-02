package com.babylon.manasidiwan.babylontestapp.Modal;

import com.google.gson.annotations.SerializedName;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public class Comment {

    @SerializedName("postId")
    private long mPostId;
    @SerializedName("id")
    private long mId;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("name")
    private String mName;
    @SerializedName("body")
    private String mBody;

    public long getPostId() {
        return mPostId;
    }

    public void setPostId(long postId) {
        this.mPostId = postId;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        this.mBody = body;
    }
}
