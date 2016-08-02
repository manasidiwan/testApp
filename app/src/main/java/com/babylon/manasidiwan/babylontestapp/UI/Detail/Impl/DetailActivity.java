package com.babylon.manasidiwan.babylontestapp.UI.Detail.Impl;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;

import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.R;
import com.babylon.manasidiwan.babylontestapp.UI.Home.Impl.HomeActivity;
import com.babylon.manasidiwan.babylontestapp.UI.Home.Impl.HomeFragment;
import com.facebook.drawee.backends.pipeline.Fresco;

import roboguice.activity.RoboActionBarActivity;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public class DetailActivity extends RoboActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_home);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Post post = (Post) getIntent().getSerializableExtra(HomeActivity.EXTRA_POST);
        DetailFragment fragment = DetailFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putSerializable(HomeActivity.EXTRA_POST, post);
        fragment.setArguments(bundle);
        ft.add(R.id.fragment_container, fragment, "DETAIL_FRAGMENT");
        ft.commit();
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
