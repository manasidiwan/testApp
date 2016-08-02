package com.babylon.manasidiwan.babylontestapp.Logic;

import android.content.Context;

import com.babylon.manasidiwan.babylontestapp.Modal.Common.ApiClient;
import com.babylon.manasidiwan.babylontestapp.Modal.Common.ApiInterface;
import com.babylon.manasidiwan.babylontestapp.Modal.Comment;
import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;
//import com.google.inject.Inject;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public class UserModelImpl implements UserModel {

    private Context mContext;

    @Inject
    public UserModelImpl(Context context) {
        mContext = context;
    }

    @Override
    public Observable<List<Post>> getPosts() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        return apiService.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .asObservable();
    }

    @Override
    public Observable<List<User>> getUsers() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        return apiService.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .asObservable();
    }

    @Override
    public Observable<List<Comment>> getComments() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        return apiService.getComments()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .asObservable();
    }
}
