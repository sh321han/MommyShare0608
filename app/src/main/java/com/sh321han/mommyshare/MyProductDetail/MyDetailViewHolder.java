package com.sh321han.mommyshare.MyProductDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;

/**
 * Created by Administrator on 2016-05-21.
 */
public class MyDetailViewHolder extends RecyclerView.ViewHolder {
    ProductDetailData data;
    TextView detailView;

    public MyDetailViewHolder(View itemView) {
        super(itemView);
        detailView = (TextView)itemView.findViewById(R.id.text_detail);
    }

    public void setData(ProductDetailData data) {
        this.data = data;

        detailView.setText(data.getContent());
    }
}
