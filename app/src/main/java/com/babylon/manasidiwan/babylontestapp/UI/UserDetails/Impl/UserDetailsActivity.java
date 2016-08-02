package com.babylon.manasidiwan.babylontestapp.UI.UserDetails.Impl;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.babylon.manasidiwan.babylontestapp.Modal.User;
import com.babylon.manasidiwan.babylontestapp.R;
import com.babylon.manasidiwan.babylontestapp.UI.Home.Impl.HomeActivity;

import roboguice.activity.RoboActionBarActivity;

/**
 * Created by manasidiwan on 02/08/2016.
 */
public class UserDetailsActivity extends RoboActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        User user = (User) getIntent().getSerializableExtra(HomeActivity.EXTRA_USER);
        UserDetailsFragment fragment = UserDetailsFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putSerializable(HomeActivity.EXTRA_USER, user);
        fragment.setArguments(bundle);
        ft.add(R.id.fragment_user_details, fragment, "USER_DETAIL_FRAGMENT");
        ft.commit();
    }
}
