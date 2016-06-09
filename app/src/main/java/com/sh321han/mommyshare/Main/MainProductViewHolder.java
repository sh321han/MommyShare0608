package com.sh321han.mommyshare.Main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.MainProduct;

/**
 * Created by Administrator on 2016-05-15.
 */
public class MainProductViewHolder extends RecyclerView.ViewHolder {

    private static final String MOMMYSHARE_SERVER = "http://52.79.57.157:3000";
//    private static final String A = "http://52.79.57.157:3000/images/products/wcj4igkh.jpeg";


    ImageView thumbView, markView;
    TextView nameView, priceView, depositView, periodView;
    MainProduct product;
    CheckBox heartView;


    public interface OnItemClickListener {
        public void onItemClick(View view, MainProduct mainproduct);
    }

    public interface OnHeartClickListener {
        public void onHeartClick(View view, MainProduct product);
    }

    OnItemClickListener mListener;
    OnHeartClickListener hListener;

    public void setOnHeartClickListener(OnHeartClickListener listener) {
        hListener = listener;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public MainProductViewHolder(View itemView) {
        super(itemView);
        thumbView = (ImageView) itemView.findViewById(R.id.image_thumb);
        nameView = (TextView) itemView.findViewById(R.id.text_name);
        priceView = (TextView) itemView.findViewById(R.id.text_price);
        depositView = (TextView) itemView.findViewById(R.id.text_deposit);
        periodView = (TextView) itemView.findViewById(R.id.text_period);
        markView = (ImageView) itemView.findViewById(R.id.mark_borrow);

        heartView = (CheckBox) itemView.findViewById(R.id.heart);
//        heartView.setSelected(true);
        heartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hListener != null) {
                    hListener.onHeartClick(v, product);

                }
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(v, product);
                }
            }
        });


    }



    public void setProduct(MainProduct product) {
        this.product = product;

        if (product.getPicture_name().size() != 0) {
            Glide.with(thumbView.getContext()).load(MOMMYSHARE_SERVER + product.getPicture_path() + product.getPicture_name().get(0)).into(thumbView);
        }

        nameView.setText(product.getName());
        priceView.setText("대여료 " + product.getRent_fee());
        depositView.setText("보증금 " + product.getRent_deposit());
        periodView.setText("대여기간 " + product.getMin_rent_period() + " 일 ~ " + product.getMax_rent_period() + " 일");

    }
}
