package com.sh321han.mommyshare.Main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.MainProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-15.
 */
public class MainProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MainProduct> items = new ArrayList<>();

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void add(MainProduct product) {
        items.add(product);
        notifyDataSetChanged();
    }

    public void addAll(List<MainProduct> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public static final int VIEW_TYPE_SPINNER = 0;
    public static final int VIEW_TYPE_PRODUCT = 1;


    MainProductViewHolder.OnHeartClickListener hListener;

    public void setOnHeartClickListener(MainProductViewHolder.OnHeartClickListener listener) {
        hListener = listener;
    }

    MainProductViewHolder.OnItemClickListener mListener;

    public void setOnItemClickListener(MainProductViewHolder.OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        MainProduct data = items.get(position);

        return VIEW_TYPE_PRODUCT;

        /*if (position == 0) {
            return VIEW_TYPE_SPINNER;
        } else {
            return VIEW_TYPE_PRODUCT;
        }
*/
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType) {
//            case VIEW_TYPE_SPINNER:
//                view = inflater.inflate(R.layout.view_main_spinner, parent, false);
//                return new MainSpinnerViewHolder(view);
            case VIEW_TYPE_PRODUCT:
                view = inflater.inflate(R.layout.view_main_product, parent, false);
                return new MainProductViewHolder(view);

        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
//            case VIEW_TYPE_SPINNER:
//                break;
            case VIEW_TYPE_PRODUCT:
                ((MainProductViewHolder) holder).setProduct(items.get(position));
                ((MainProductViewHolder) holder).setOnItemClickListener(mListener);
                ((MainProductViewHolder) holder).setOnHeartClickListener(hListener);
                break;

        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
