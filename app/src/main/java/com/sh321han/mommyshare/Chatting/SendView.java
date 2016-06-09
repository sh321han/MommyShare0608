package com.sh321han.mommyshare.Chatting;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh321han.mommyshare.R;

/**
 * Created by Tacademy on 2016-06-09.
 */
public class SendView extends FrameLayout {
    public SendView(Context context) {
        super(context);
        init();
    }

    TextView messageView;
    ImageView iconView;
    private void init() {
        inflate(getContext(), R.layout.view_send, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        messageView = (TextView)findViewById(R.id.text_message);
    }

    public void setData(Send data) {
        messageView.setText(data.message);
        iconView.setImageDrawable(data.icon);
    }
}

