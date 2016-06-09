package com.sh321han.mommyshare.Chatting;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.sh321han.mommyshare.R;

public class ChattingActivity extends AppCompatActivity {


    EditText inputView;
    RadioGroup typeView;
    ListView listView;
    ChatAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        inputView = (EditText)findViewById(R.id.edit_input);
        typeView = (RadioGroup)findViewById(R.id.group_type);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new ChatAdapter();
        listView.setAdapter(mAdapter);

        String message = inputView.getText().toString();
        Send send = new Send();
        send.message = message;
        send.icon = ContextCompat.getDrawable(ChattingActivity.this, R.mipmap.ic_launcher);
        mAdapter.add(send);
        Button btn = (Button)findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = inputView.getText().toString();
                if (!TextUtils.isEmpty(message)) {
                    switch (typeView.getCheckedRadioButtonId()) {
                        case R.id.radio_s :
                            Send send = new Send();
                            send.message = message;
                            send.icon = ContextCompat.getDrawable(ChattingActivity.this, R.mipmap.ic_launcher);
                            mAdapter.add(send);
                            break;
                        case R.id.radio_r :
                            Receive receive = new Receive();
                            receive.message = message;
                            receive.icon = ContextCompat.getDrawable(ChattingActivity.this, R.mipmap.ic_launcher);
                            mAdapter.add(receive);
                            break;
                        case R.id.radio_d :
                            Date date = new Date();
                            date.message = message;
                            mAdapter.add(date);
                            break;
                    }
                    inputView.setText("");
                }
            }
        });
    }
}
