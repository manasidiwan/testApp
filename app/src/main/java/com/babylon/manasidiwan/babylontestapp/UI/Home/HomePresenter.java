package com.babylon.manasidiwan.babylontestapp.UI.Home;

import com.babylon.manasidiwan.babylontestapp.Modal.Post;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public interface HomePresenter {

    void onViewAttach(HomeView view);

    void onViewDetach();

    void prepareData();

    void fetchPosts();

    void postClicked(Post post);

    void fetchUsers();
}
