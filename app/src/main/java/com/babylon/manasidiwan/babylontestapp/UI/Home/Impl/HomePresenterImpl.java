package com.babylon.manasidiwan.babylontestapp.UI.Home.Impl;

import android.content.Context;

import com.babylon.manasidiwan.babylontestapp.Logic.UserProvider;
import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;
import com.babylon.manasidiwan.babylontestapp.UI.Home.HomePresenter;
import com.babylon.manasidiwan.babylontestapp.UI.Home.HomeView;
//import com.google.inject.Inject;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * @author manasidiwan
 */
public class HomePresenterImpl implements HomePresenter {

    @Inject
    UserProvider mProvider;

    private HomeView mView;
    private Context mContext;

    @Inject
    public HomePresenterImpl(Context context) {
        mContext = context;
    }

    @Override
    public void onViewAttach(HomeView view) {
        mView = view;
    }

    @Override
    public void onViewDetach() {
        mView = null;
    }

    @Override
    public void prepareData() {
        fetchUsers();
        fetchPosts();
    }

    @Override
    public void fetchPosts() {
        Observable<List<Post>> observable = mProvider.getPosts();
        Observer observer = new Observer<List<Post>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Post> list) {
                mView.showList(list);
            }
        };

        observable.subscribe(observer);
    }

    @Override
    public void fetchUsers() {
        Observable<List<User>> observable = mProvider.getUsers();
        Observer observer = new Observer<List<User>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<User> users) {
                mView.updateUserDetails(users);
            }
        };

        observable.subscribe(observer);
    }

    @Override
    public void postClicked(Post post) {
        mView.openDetailView(post);
    }
}
