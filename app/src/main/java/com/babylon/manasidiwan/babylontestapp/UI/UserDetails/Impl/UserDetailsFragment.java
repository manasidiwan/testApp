package com.babylon.manasidiwan.babylontestapp.UI.UserDetails.Impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.babylon.manasidiwan.babylontestapp.Modal.Address;
import com.babylon.manasidiwan.babylontestapp.Modal.Company;
import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;
import com.babylon.manasidiwan.babylontestapp.R;
import com.babylon.manasidiwan.babylontestapp.UI.Common.DividerItemDecoration;
import com.babylon.manasidiwan.babylontestapp.UI.Detail.Impl.DetailActivity;
import com.babylon.manasidiwan.babylontestapp.UI.Home.HomePresenter;
import com.babylon.manasidiwan.babylontestapp.UI.Home.Impl.HomeActivity;
import com.babylon.manasidiwan.babylontestapp.UI.Home.Impl.HomeAdapter;
import com.babylon.manasidiwan.babylontestapp.UI.UserDetails.UserDetailsPresenter;
import com.babylon.manasidiwan.babylontestapp.UI.UserDetails.UserDetailsView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import roboguice.fragment.RoboFragment;

/**
 * @author manasidiwan on 02/08/2016.
 */
public class UserDetailsFragment extends RoboFragment implements UserDetailsView {
    public static UserDetailsFragment newInstance() {
        return new UserDetailsFragment();
    }

    @Bind(R.id.username)
    TextView mUserNameView;

    @Bind(R.id.name)
    TextView mNameView;

    @Bind(R.id.email)
    TextView mEmailView;

    @Bind(R.id.address)
    TextView mAddressView;

    @Bind(R.id.phone)
    TextView mPhoneView;

    @Bind(R.id.website)
    TextView mWebsiteView;

    @Bind(R.id.company)
    TextView mCompanyView;

    private String mUsername;
    private String mName;
    private Address mAddress;
    private String mEmail;
    private String mPhone;
    private String mWebsite;
    private Company mCompany;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = (User) getArguments().getSerializable(HomeActivity.EXTRA_USER);
        mUsername = user.getUserName();
        mName = user.getName();
        mAddress = user.getAddress();
        mEmail = user.getEmail();
        mPhone = user.getPhone();
        mWebsite = user.getWebsite();
        mCompany = user.getCompany();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUserNameView.setText(mUsername);
        mNameView.setText(mName);
        mEmailView.setText(mEmail);
        mWebsiteView.setText(mWebsite);
        mPhoneView.setText(mPhone);
    }
}
