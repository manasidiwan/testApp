package com.babylon.manasidiwan.babylontestapp.UI.Home.Impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;
import com.babylon.manasidiwan.babylontestapp.UI.Common.DividerItemDecoration;
import com.babylon.manasidiwan.babylontestapp.UI.Detail.Impl.DetailActivity;
import com.babylon.manasidiwan.babylontestapp.UI.Home.HomePresenter;
import com.babylon.manasidiwan.babylontestapp.UI.Home.HomeView;
import com.babylon.manasidiwan.babylontestapp.R;
//import com.google.inject.Inject;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import roboguice.fragment.RoboFragment;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public class HomeFragment extends RoboFragment implements HomeView {


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    HomePresenter mPresenter;

    private List<Post> mList;

    private GridLayoutManager mLayoutManager;
    private HomeAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getResources()));
        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mPresenter.prepareData();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdapter == null) {
            mAdapter = new HomeAdapter(getActivity().getApplicationContext(), mPresenter);
            mRecyclerView.setAdapter(mAdapter);
            if (mList != null) {
                showList(mList);
            }
        }
        mPresenter.onViewAttach(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onViewDetach();
    }

    @Override
    public void showList(List<Post> list) {
        mList = list;
        mAdapter.setNewData(list);
    }

    @Override
    public void updateUserDetails(List<User> users) {
        mAdapter.setUserListData(users);
    }

    @Override
    public void openDetailView(Post post) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(HomeActivity.EXTRA_POST, post);
        getActivity().startActivity(intent);
    }
}
