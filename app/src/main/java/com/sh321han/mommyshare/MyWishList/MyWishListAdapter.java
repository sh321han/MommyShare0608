package com.sh321han.mommyshare.MyWishList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.WishProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-05-19.
 */
public class MyWishListAdapter extends RecyclerView.Adapter<MyWishListViewHolder> {
    List<WishProduct> items = new ArrayList<>();

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void add(WishProduct wishproduct) {
        items.add(wishproduct);
        notifyDataSetChanged();
    }

    public void addAll(List<WishProduct> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    MyWishListViewHolder.OnItemClickListener mListener;
    public void setOnItemClickListener(MyWishListViewHolder.OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public MyWishListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_wish_product, null);
        return new MyWishListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyWishListViewHolder holder, int position) {
        holder.setWishProduct(items.get(position));
        holder.setOnItemClickListener(mListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
