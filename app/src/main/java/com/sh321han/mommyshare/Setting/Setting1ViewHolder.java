package com.sh321han.mommyshare.Setting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.SettingData;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class Setting1ViewHolder extends RecyclerView.ViewHolder {

    TextView setting1View;
    Switch switchView;

    public Setting1ViewHolder(View itemView) {
        super(itemView);
        setting1View = (TextView)itemView.findViewById(R.id.text_content1);
        switchView = (Switch)itemView.findViewById(R.id.switch1);
    }

    public void setSettingTop(SettingData data) { setting1View.setText(data.getContent1());}
}
