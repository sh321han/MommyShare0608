package com.sh321han.mommyshare.Profile;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sh321han.mommyshare.data.ProfileReview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-19.
 */
public class ProfileReviewAdapter extends BaseAdapter implements ProfileReviewView.OnImageClickListener {

    List<ProfileReview> items = new ArrayList<ProfileReview>();

   public void add(ProfileReview p){
        items.add(p);
        notifyDataSetChanged();
    }

    public void remove(ProfileReview p) {
        items.remove(p);
        notifyDataSetChanged();
    }

    public void addAll(List<ProfileReview> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProfileReviewView view;
        if (convertView == null) {
            view = new ProfileReviewView(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (ProfileReviewView)convertView;
        }
        view.setMyProfile(items.get(position));
        view.setOnImageClickListener(imageClickListener);
        return view;
    }

    ProfileReviewView.OnImageClickListener imageClickListener;
    public void setOnImageClickListener(ProfileReviewView.OnImageClickListener listener) {
        imageClickListener = listener;
    }

    @Override
    public void onImageClick(ProfileReviewView view, ProfileReview myprofile) {
        if (mListener != null) {
            mListener.onItemImageClick(this, view, myprofile);
        }
    }

    public interface OnAdapterItemClickListener {
        public void onItemImageClick(ProfileReviewAdapter apdater, ProfileReviewView view, ProfileReview myprofile);
    }

    OnAdapterItemClickListener mListener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickListener listener) {
        mListener = listener;
    }
}
