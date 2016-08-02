package com.babylon.manasidiwan.babylontestapp.Logic;

import com.babylon.manasidiwan.babylontestapp.Modal.Comment;
import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;

import java.util.List;

import rx.Observable;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public interface UserProvider {

    Observable<List<Post>> getPosts();

    Observable<List<User>> getUsers();

    Observable<User> getUser(long userId);

    Observable<List<Comment>> getComments();

}
