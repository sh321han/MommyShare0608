package com.sh321han.mommyshare.Setting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.SettingData;

/**
 * Created by Administrator on 2016-05-22.
 */
public class Setting2ViewHolder extends RecyclerView.ViewHolder {

    TextView setting2View;
    SettingData data;

    public interface OnItemClickListener {
        public void onItemClicked(Setting2ViewHolder holder,View view, SettingData data, int position);
    }

    OnItemClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener) {mItemClickListener = listener; }



    public Setting2ViewHolder(View itemView) {
        super(itemView);
        setting2View = (TextView)itemView.findViewById(R.id.text_content2);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if(mItemClickListener != null) {
                    mItemClickListener.onItemClicked(Setting2ViewHolder.this, v, data, position );
                }
            }
        });

    }

    public void setSetting(SettingData data) { setting2View.setText(data.getContent2());}
}
