package com.sh321han.mommyshare.MyWishList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.WishProduct;

/**
 * Created by Tacademy on 2016-05-19.
 */
public class MyWishListViewHolder extends RecyclerView.ViewHolder {

    ImageView thumbView, heartView;
    TextView nameView, priceView, depositView,periodView, markView;
    WishProduct wishproduct;

    public interface OnItemClickListener {
        public void onItemClick(View view, WishProduct wishproduct);
    }

    OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) { mListener = listener; }

    public MyWishListViewHolder(View itemView) {
        super(itemView);

        thumbView = (ImageView)itemView.findViewById(R.id.image_wish_thumb);
        nameView = (TextView)itemView.findViewById(R.id.text_wish_name);
        priceView = (TextView)itemView.findViewById(R.id.text_wish_price);
        depositView = (TextView)itemView.findViewById(R.id.text_wish_deposit);
        periodView = (TextView)itemView.findViewById(R.id.text_wish_period);
        markView = (TextView)itemView.findViewById(R.id.wish_mark_borrow);
        heartView = (ImageView)itemView.findViewById(R.id.wish_heart);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null) {
                    mListener.onItemClick(v, wishproduct);
                }
            }
        });
    }

    public void setWishProduct(WishProduct wishproduct) {
        this.wishproduct = wishproduct;

        nameView.setText(wishproduct.getWish_name());
        priceView.setText("대여료 " + wishproduct.getWish_price());
        depositView.setText("보증금 " + wishproduct.getWish_deposit());
        periodView.setText("대여기간 "+ wishproduct.getWish_minPeriod()+" 일 ~ " + wishproduct.getWish_maxPeriod()+" 일");


    }
}
