package com.sh321han.mommyshare.MyProductDetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;

/**
 * Created by Administrator on 2016-05-21.
 */
public class MyProductDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ProductDetailData item = null;

    public void add(ProductDetailData data) {
        item = data;
        notifyDataSetChanged();
    }


    private static final int VIEW_TYPE_PAGER = 0;
    private static final int VIEW_TYPE_DESC = 1;
    private static final int VIEW_TYPE_DETAIL = 2;
    private static final int VIEW_TYPE_REVIEW = 3;

    @Override
    public int getItemViewType(int position) {


        if (position == 0) {
            return VIEW_TYPE_PAGER;
        } else if (position == 1) {
            return VIEW_TYPE_DESC;
        } else if (position == 2) {
            return VIEW_TYPE_DETAIL;
        } else
            return VIEW_TYPE_REVIEW;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType) {
            case VIEW_TYPE_PAGER :
                view = inflater.inflate(R.layout.view_my_product_detail_vp, parent, false);
                return new MyPagerViewHolder(view);
            case VIEW_TYPE_DESC:
                view = inflater.inflate(R.layout.view_my_product_detail_desc, parent, false);
                return new MyDescViewHolder(view);
            case VIEW_TYPE_DETAIL:
                view = inflater.inflate(R.layout.view_my_product_detail_dt, parent, false);
                return new MyDetailViewHolder(view);
            case VIEW_TYPE_REVIEW:
                view = inflater.inflate(R.layout.view_my_product_detail_review, parent, false);
                return new MyReviewViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
//            case VIEW_TYPE_PAGER :
//                ((MyPagerViewHolder) holder).setData(item);
//                break;
            case VIEW_TYPE_DESC:
                ((MyDescViewHolder) holder).setData(item);
                break;
            case VIEW_TYPE_DETAIL:
                ((MyDetailViewHolder) holder).setData(item);
                break;
            case VIEW_TYPE_REVIEW:
                ((MyReviewViewHolder) holder).setData(item.getReviews().get(position-3));
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (item == null) return 0;
        return item.getReviews().size() + 3;
    }
}
