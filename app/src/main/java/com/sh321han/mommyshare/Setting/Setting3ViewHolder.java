package com.sh321han.mommyshare.Setting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.SettingData;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class Setting3ViewHolder extends RecyclerView.ViewHolder {
    TextView setting3View;
    SettingData data;

    public interface OnItemClickListener {
        public void onItemClicked(Setting3ViewHolder holder,View view, SettingData data, int position);
    }

    OnItemClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener) {mItemClickListener = listener; }

    public Setting3ViewHolder(View itemView) {
        super(itemView);
        setting3View = (TextView)itemView.findViewById(R.id.text_content3);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if(mItemClickListener != null) {
                    mItemClickListener.onItemClicked(Setting3ViewHolder.this, v, data, position );
                }
            }
        });
    }

    public void setSetting(SettingData data) { setting3View.setText(data.getContent3());}
}
