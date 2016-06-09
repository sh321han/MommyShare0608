package com.sh321han.mommyshare.OtherProductDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sh321han.mommyshare.R;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class OtherWriteViewHolder extends RecyclerView.ViewHolder {

    EditText editReview;
    ImageButton btn_input;

    public interface OnClickButtonListener{
        public void onClickBtn(View v, EditText etText);
    }

    OnClickButtonListener mListener;
    public void setButtonClickListener(OnClickButtonListener listener){
        mListener=listener;
    }

    public OtherWriteViewHolder(View itemView) {
        super(itemView);
        editReview = (EditText)itemView.findViewById(R.id.editReview);
        btn_input = (ImageButton)itemView.findViewById(R.id.btn_input);
        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClickBtn(v, editReview);

            }
        });

    }
}
