package com.babylon.manasidiwan.babylontestapp.UI.Home.Impl;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.babylon.manasidiwan.babylontestapp.Modal.Post;
import com.babylon.manasidiwan.babylontestapp.Modal.User;
import com.babylon.manasidiwan.babylontestapp.R;
import com.babylon.manasidiwan.babylontestapp.UI.Home.HomePresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import roboguice.RoboGuice;

/**
 * @author manasidiwan on 01/08/2016.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private HomePresenter mPresenter;
    private Context mContext;
    private List<Post> mListData;
    private List<User> mUserListData;
    private static final int HEADER = 0;
    private static final int LIST_ITEM = 1;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.post_title)
        public TextView mPostTitle;

        @Bind(R.id.item_image)
        public SimpleDraweeView mImageView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public HomeAdapter(Context context, HomePresenter presenter) {
        mPresenter = presenter;
        mContext = context.getApplicationContext();
        RoboGuice.getInjector(context).injectMembers(this);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = mListData.get(viewHolder.getAdapterPosition());
                mPresenter.postClicked(post);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).mPostTitle.setText(mListData.get(position).getTitle());
            if (mUserListData != null) {
                for (User user: mUserListData) {
                    if (user.getId() == mListData.get(position).getUserId()) {
                        Uri imageUri = Uri.parse("http://api.adorable.io/avatar/" + user.getEmail());
                        ((ViewHolder) holder).mImageView.setImageURI(imageUri);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return (mListData == null) ? 0 : mListData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == HEADER) {
            return HEADER;
        } else {
            return LIST_ITEM;
        }
    }

    public void setNewData(List<Post> data) {
        mListData = data;
        notifyDataSetChanged();
    }

    public void setUserListData(List<User> data) {
        mUserListData = data;
    }
}
