package com.sh321han.mommyshare.MyProductDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductReviewData;

/**
 * Created by Administrator on 2016-05-21.
 */
public class MyReviewViewHolder extends RecyclerView.ViewHolder {
    ProductReviewData data;
    ImageView profileView;
    TextView nameView, timeView, reviewView;

    public MyReviewViewHolder(View itemView) {
        super(itemView);
        profileView = (ImageView)itemView.findViewById(R.id.image_profile);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        timeView = (TextView)itemView.findViewById(R.id.text_time);
        reviewView = (TextView)itemView.findViewById(R.id.text_review);
    }

    public void setData(ProductReviewData data) {
        this.data = data;

//        profileView.setImageDrawable(data.getReview_profile());
       //        timeView.setText(data.getReview_time());
        reviewView.setText(data.getContent());
    }
}
