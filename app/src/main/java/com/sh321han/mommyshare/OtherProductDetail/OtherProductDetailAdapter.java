package com.sh321han.mommyshare.OtherProductDetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class OtherProductDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    ProductDetailData item = null;


    OtherWriteViewHolder.OnClickButtonListener mListener;
    public void setClickButtonListener(OtherWriteViewHolder.OnClickButtonListener listener){
        mListener=listener;
    }

    public void clear(){
        item = new ProductDetailData();
        notifyDataSetChanged();
    }

    public void set(ProductDetailData data) {
        item = data;
        notifyDataSetChanged();
    }


    private static final int VIEW_TYPE_PAGER = 0;
    private static final int VIEW_TYPE_LENDER = 1;
    private static final int VIEW_TYPE_DESC = 2;
    private static final int VIEW_TYPE_DETAIL = 3;
    private static final int VIEW_TYPE_WRITE = 4;
    private static final int VIEW_TYPE_REVIEW = 5;

    @Override
    public int getItemViewType(int position) {


        if (position == 0) {
            return VIEW_TYPE_PAGER;
        } else if (position == 1) {
            return VIEW_TYPE_LENDER;
        } else if (position == 2) {
            return VIEW_TYPE_DESC;
        } else if (position == 3) {
            return VIEW_TYPE_DETAIL;
        } else if (position == 4) {
            return VIEW_TYPE_WRITE;
        } else {
            return VIEW_TYPE_REVIEW;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType) {
            case VIEW_TYPE_PAGER :
                view = inflater.inflate(R.layout.view_other_product_detail_vp, parent, false);
                return new OtherPagerViewHolder(view);
            case VIEW_TYPE_LENDER :
                view = inflater.inflate(R.layout.view_other_product_detail_lender, parent, false);
                return new LenderViewHolder(view);
            case VIEW_TYPE_DESC :
                view = inflater.inflate(R.layout.view_other_product_detail_desc, parent, false);
                return new OtherDescViewHolder(view);
            case VIEW_TYPE_DETAIL:
                view = inflater.inflate(R.layout.view_other_product_detail_dt, parent, false);
                return new OtherDetailViewHolder(view);
            case VIEW_TYPE_WRITE :
                view = inflater.inflate(R.layout.view_other_product_detail_write, parent, false);
                return new OtherWriteViewHolder(view);
            case VIEW_TYPE_REVIEW :
                view = inflater.inflate(R.layout.view_other_product_detail_review, parent, false);
                return new OtherReviewViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
//            case VIEW_TYPE_PAGER :
//                ((OtherPagerViewHolder)holder).setData(item);
//                break;
            case VIEW_TYPE_LENDER:
                ((LenderViewHolder) holder).setData(item);
                break;
            case VIEW_TYPE_DESC:
                ((OtherDescViewHolder) holder).setData(item);
                break;
            case VIEW_TYPE_DETAIL:
                ((OtherDetailViewHolder) holder).setData(item);
                break;
            case VIEW_TYPE_WRITE :
                ((OtherWriteViewHolder)holder).setButtonClickListener(mListener);
                break;
            case VIEW_TYPE_REVIEW :
                ((OtherReviewViewHolder)holder).setData(item.getReviews().get(position-5));
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (item == null) return 0;
        return item.getReviews().size() + 5;
    }

}
