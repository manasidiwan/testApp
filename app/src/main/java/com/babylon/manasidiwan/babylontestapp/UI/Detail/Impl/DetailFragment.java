package com.babylon.manasidiwan.babylontestapp.UI.Detail.Impl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;
import com.babylon.manasidiwan.babylontestapp.R;
import com.babylon.manasidiwan.babylontestapp.UI.Detail.DetailPresenter;
import com.babylon.manasidiwan.babylontestapp.UI.Detail.DetailView;
import com.babylon.manasidiwan.babylontestapp.UI.Home.Impl.HomeActivity;
import com.babylon.manasidiwan.babylontestapp.UI.UserDetails.Impl.UserDetailsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import roboguice.fragment.RoboFragment;

/**
 * @author manasidiwan on 01/08/2016.
 */
public class DetailFragment extends RoboFragment implements DetailView {

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }


    @Inject
    DetailPresenter mPresenter;


    private GridLayoutManager mLayoutManager;


    @Bind(R.id.post_title)
    TextView mPostTitle;

    @Bind(R.id.post_body)
    TextView mPostBody;

    @Bind(R.id.username)
    TextView mUserName;

    @Bind(R.id.numberOfComments)
    TextView mNumberOfComments;

    @Bind(R.id.item_image)
    public SimpleDraweeView mImageView;

    private long mUserId;
    private long mPostId;
    private String mTitle;
    private String mBody;
    private User mUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Post post = (Post) getArguments().getSerializable(HomeActivity.EXTRA_POST);
        mPostId = post.getId();
        mUserId = post.getUserId();
        mTitle = post.getTitle();
        mBody = post.getBody();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.prepareData(mUserId, mPostId);
        mPostBody.setText(mBody);
        mPostTitle.setText(mTitle);
        mUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserDetailsActivity.class);
                intent.putExtra(HomeActivity.EXTRA_USER, mUser);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onViewAttach(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onViewDetach();
    }

    @Override
    public void updateUserDetails(User user) {
        mUser = user;
        mUserName.setText(user.getUserName());
        Uri imageUri = Uri.parse("http://api.adorable.io/avatar/" + user.getEmail());
        mImageView.setImageURI(imageUri);
    }

    @Override
    public void updateNumberOfComments(Integer number) {
        mNumberOfComments.setText(String.valueOf(number));
    }
}
