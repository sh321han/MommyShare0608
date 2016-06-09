package com.sh321han.mommyshare.OtherProductDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class LenderViewHolder extends RecyclerView.ViewHolder {

    ProductDetailData data;
    ImageView profileView;
    TextView nameView;
    ImageButton btn_chat;

    public LenderViewHolder(View itemView) {
        super(itemView);
        profileView = (ImageView)itemView.findViewById(R.id.image_profile);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        btn_chat = (ImageButton) itemView.findViewById(R.id.btn_chat);
    }

    public void setData(ProductDetailData data) {
        this.data = data;

        nameView.setText(data.getMember_name());

    }
}
