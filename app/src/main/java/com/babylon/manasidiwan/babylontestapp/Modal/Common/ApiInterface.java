package com.babylon.manasidiwan.babylontestapp.Modal.Common;

import com.babylon.manasidiwan.babylontestapp.Modal.Comment;
import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author manasidiwan
 */
public interface ApiInterface {

    @GET("posts")
    Observable<List<Post>> getPosts();

    @GET("users")
    Observable<List<User>> getUsers();

    @GET("comments")
    Observable<List<Comment>> getComments();
}
