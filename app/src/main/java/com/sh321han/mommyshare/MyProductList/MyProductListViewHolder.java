package com.sh321han.mommyshare.MyProductList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.MyProduct;

/**
 * Created by Tacademy on 2016-05-16.
 */
public class MyProductListViewHolder extends RecyclerView.ViewHolder {

    ImageView thumbView;
    TextView nameView, priceView, depositView,periodView, markView;
    MyProduct myproduct;

    public interface OnItemClickListener {
        public void onItemClick(View view, MyProduct myproduct);
    }

    OnItemClickListener mListener;

    public  void setOnItemClickListener(OnItemClickListener listener) { mListener = listener; }


    public MyProductListViewHolder(View itemView) {
        super(itemView);
        thumbView = (ImageView)itemView.findViewById(R.id.image_my_thumb);
        nameView = (TextView)itemView.findViewById(R.id.text_my_name);
        priceView = (TextView)itemView.findViewById(R.id.text_my_price);
        depositView = (TextView)itemView.findViewById(R.id.text_my_deposit);
        periodView = (TextView)itemView.findViewById(R.id.text_my_period);
        markView = (TextView)itemView.findViewById(R.id.my_mark_borrow);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null) {
                    mListener.onItemClick(v, myproduct);
                }
            }
        });
    }

    public void setMyProduct(MyProduct myproduct) {
        this.myproduct = myproduct;

        nameView.setText(myproduct.getMy_name());
        priceView.setText("대여료 " + myproduct.getMy_price());
        depositView.setText("보증금 " + myproduct.getMy_deposit());
        periodView.setText("대여기간 "+myproduct.getMy_minPeriod() +" 일 ~ " + myproduct.getMy_maxPeriod()+" 일");
    }
}
