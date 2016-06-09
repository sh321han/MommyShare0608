package com.sh321han.mommyshare.OtherProductDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class OtherDescViewHolder extends RecyclerView.ViewHolder {

    TextView nameView, priceView, depositView, periodView, locationView;
    ProductDetailData data;

    public OtherDescViewHolder(View itemView) {
        super(itemView);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        priceView = (TextView)itemView.findViewById(R.id.text_price);
        depositView = (TextView)itemView.findViewById(R.id.text_deposit);
        periodView = (TextView)itemView.findViewById(R.id.text_period);
        locationView = (TextView)itemView.findViewById(R.id.text_location);
    }

    public void setData(ProductDetailData data) {
        this.data = data;
        nameView.setText(data.getName());
        priceView.setText("대여료 | " + data.getRent_fee());
        depositView.setText("보증금 | " + data.getRent_deposit());
        periodView.setText("대여기간 | " + data.getMin_rent_period() + "일 ~" + data.getMax_rent_period() + "일");
        locationView.setText("대여장소 | " + data.getLocation());

    }
}
