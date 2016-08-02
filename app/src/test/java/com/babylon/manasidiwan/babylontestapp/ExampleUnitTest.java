package com.babylon.manasidiwan.babylontestapp;

import android.content.Context;

import com.babylon.manasidiwan.babylontestapp.Logic.UserModelImpl;
import com.babylon.manasidiwan.babylontestapp.Logic.UserProviderImpl;
import com.babylon.manasidiwan.babylontestapp.Modal.User;

import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import rx.Subscriber;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    private static final String FAKE_STRING = "TEST_APP";

    @Mock
    Context mMockContext;

    @Test
    public void getUsers() throws Exception {
        UserModelImpl model = new UserModelImpl(mMockContext);
        model.getUsers().subscribe(new Subscriber<List<User>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<User> users) {
                assertEquals(users.size(), 25);
            }
        });

    }

    @Test
    public void getUser() throws Exception {
        UserProviderImpl model = new UserProviderImpl(mMockContext);
        model.getUser(1).subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {
                assertEquals(user.getId(), 1);
                assertEquals(user.getUserName(), "Bret");
            }
        });

    }

    @Test
    public void getInvalidUser() throws Exception {
        UserProviderImpl model = new UserProviderImpl(mMockContext);
        model.getUser(-1).subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                assertTrue(true);
            }

            @Override
            public void onNext(User user) {

            }
        });
    }
}