package com.sh321han.mommyshare.Setting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.SettingData;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class Setting5ViewHolder extends RecyclerView.ViewHolder {

    TextView setting5View;


    public Setting5ViewHolder(View itemView) {
        super(itemView);
        setting5View = (TextView)itemView.findViewById(R.id.text_content5);

    }

    public void setSetting(SettingData data) { setting5View.setText(data.getContent5());}
}
