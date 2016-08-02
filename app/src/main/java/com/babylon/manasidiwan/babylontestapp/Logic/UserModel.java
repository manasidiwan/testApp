package com.babylon.manasidiwan.babylontestapp.Logic;

import com.babylon.manasidiwan.babylontestapp.Modal.Comment;
import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;

import java.util.List;

import rx.Observable;

/**
 * @author manasidiwan.
 */
public interface UserModel {

    Observable<List<Post>> getPosts();

    Observable<List<User>> getUsers();

    Observable<List<Comment>> getComments();


}
