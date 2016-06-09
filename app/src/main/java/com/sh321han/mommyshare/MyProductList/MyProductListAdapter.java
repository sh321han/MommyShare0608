package com.sh321han.mommyshare.MyProductList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.MyProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-05-16.
 */
public class MyProductListAdapter extends RecyclerView.Adapter<MyProductListViewHolder> {
    List<MyProduct> items = new ArrayList<>();

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void add(MyProduct product) {
        items.add(product);
        notifyDataSetChanged();
    }

    public void addAll(List<MyProduct> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    MyProductListViewHolder.OnItemClickListener mListener;
    public void setOnItemClickListener(MyProductListViewHolder.OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public MyProductListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_my_product_list, null);
        return new MyProductListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyProductListViewHolder holder, int position) {
        holder.setMyProduct(items.get(position));
        holder.setOnItemClickListener(mListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
