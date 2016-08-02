package com.babylon.manasidiwan.babylontestapp.UI.Detail;

import com.babylon.manasidiwan.babylontestapp.UI.Home.HomeView;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public interface DetailPresenter {

    void onViewAttach(DetailView view);

    void onViewDetach();

    void prepareData(long userId, long postId);

    void fetchUser(long userId);

    void fetchComments(long postId);

}
