package com.sh321han.mommyshare.Setting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.SettingData;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class Setting4ViewHolder extends RecyclerView.ViewHolder{

    TextView setting4View;
    SettingData data;

    public interface OnItemClickListener {
        public void onItemClicked(Setting4ViewHolder holder,View view, SettingData data, int position);
    }

    OnItemClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener) {mItemClickListener = listener; }

    public Setting4ViewHolder(View itemView) {
        super(itemView);
        setting4View = (TextView)itemView.findViewById(R.id.text_content4);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if(mItemClickListener != null) {
                    mItemClickListener.onItemClicked(Setting4ViewHolder.this, v, data, position );
                }
            }
        });
    }

    public void setSetting(SettingData data) { setting4View.setText(data.getContent4());}
}
