package com.babylon.manasidiwan.babylontestapp.UI.Home.Impl;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.babylon.manasidiwan.babylontestapp.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import roboguice.activity.RoboActionBarActivity;

public class HomeActivity extends RoboActionBarActivity {

    public static String EXTRA_POST = "extra_post";
    public static String EXTRA_USER = "extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_home);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, HomeFragment.newInstance(), "HOME_FRAGMENT");
        ft.commit();
    }
}
