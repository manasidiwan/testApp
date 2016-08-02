package com.babylon.manasidiwan.babylontestapp.Logic;

import android.content.Context;

import com.babylon.manasidiwan.babylontestapp.Modal.Comment;
import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;

import java.util.List;

import javax.inject.Inject;

import roboguice.RoboGuice;
import rx.Observable;

/**
 * @author manasidiwan
 */
public class UserProviderImpl implements UserProvider {

    @Inject
    UserModel mModel;

    private Context mContext;

    @Inject
    public UserProviderImpl(Context context) {
        mContext = context;
        RoboGuice.getInjector(mContext).injectMembers(this);
    }

    @Override
    public Observable<List<Post>> getPosts() {
        return mModel.getPosts();
    }

    @Override
    public Observable<List<User>> getUsers() {
        return mModel.getUsers();
    }

    @Override
    public Observable<List<Comment>> getComments() {
        return mModel.getComments();
    }

    @Override
    public Observable<User> getUser(long userId) {
        return mModel.getUsers()
                .flatMap((list) -> {
                    for (User user : list) {
                        if (user.getId() == userId) {
                            return Observable.just(user);
                        }
                    }
                    return Observable.error(new Throwable("User not found"));
                });
    }
}
