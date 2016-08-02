package com.babylon.manasidiwan.babylontestapp.UI.Detail.Impl;

import android.content.Context;

import com.babylon.manasidiwan.babylontestapp.Logic.UserProvider;
import com.babylon.manasidiwan.babylontestapp.Modal.Comment;
import com.babylon.manasidiwan.babylontestapp.Modal.User;
import com.babylon.manasidiwan.babylontestapp.UI.Detail.DetailPresenter;
import com.babylon.manasidiwan.babylontestapp.UI.Detail.DetailView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public class DetailPresenterImpl implements DetailPresenter {

    @Inject
    UserProvider mProvider;

    private DetailView mView;
    private Context mContext;

    @Override
    public void onViewDetach() {
        mView = null;
    }

    @Override
    public void onViewAttach(DetailView view) {
        mView = view;
    }

    @Override
    public void fetchComments(long postId) {
        mProvider.getComments()
                .flatMap((list) -> {
                    int numberOfComments = 0;
                    for (Comment comment : list) {
                        if (comment.getPostId() == postId) {
                            numberOfComments ++;
                        }
                    }
                    return Observable.just(numberOfComments);
                } ).subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer number) {
                        mView.updateNumberOfComments(number);
                    }
                });
    }

    @Override
    public void fetchUser(long userId) {
        Observable<User> observable = mProvider.getUser(userId);
        Observer observer = new Observer<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {
                mView.updateUserDetails(user);
            }
        };

        observable.subscribe(observer);
    }

    @Override
    public void prepareData(long userId, long postId) {
        fetchComments(postId);
        fetchUser(userId);
    }
}
