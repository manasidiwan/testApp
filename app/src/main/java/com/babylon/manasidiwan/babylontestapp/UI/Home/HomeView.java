package com.babylon.manasidiwan.babylontestapp.UI.Home;

import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;

import java.util.List;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public interface HomeView {

    void showList(List<Post> posts);

    void openDetailView(Post post);

    void updateUserDetails(List<User> users);
}
