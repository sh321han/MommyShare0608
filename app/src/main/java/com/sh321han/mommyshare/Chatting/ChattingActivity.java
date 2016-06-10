package com.sh321han.mommyshare.Chatting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.sh321han.mommyshare.GCM.MyGcmListenerService;
import com.sh321han.mommyshare.Manager.DataConstant;
import com.sh321han.mommyshare.Manager.DataManager;
import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.MyResult;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.User;

import java.io.IOException;

import okhttp3.Request;

public class ChattingActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "user";

    ListView listView;
    ChatCursorAdapter mAdapter;

    EditText inputView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        user = (User)getIntent().getSerializableExtra(EXTRA_USER);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new ChatCursorAdapter(this);
        listView.setAdapter(mAdapter);
        inputView = (EditText)findViewById(R.id.edit_input);
        Button btn = (Button)findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String message = inputView.getText().toString();
                if (!TextUtils.isEmpty(message)) {
                    NetworkManager.getInstance().sendMessage(ChattingActivity.this, user.id, message, new NetworkManager.OnResultListener<MyResult<String>>() {
                        @Override
                        public void onSuccess(Request request, MyResult<String> result) {
                            if (userid == -1) {
                                userid = DataManager.getInstance().getUserTableId(user);
                            }
                            DataManager.getInstance().addChatMessage(userid, DataConstant.ChatTable.TYPE_SEND, message, null);
                            initData();
                            inputView.setText("");
                        }

                        @Override
                        public void onFail(Request request, IOException exception) {

                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
        LocalBroadcastManager.getInstance(this).registerReceiver(mChatReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mChatReceiver);
    }

    IntentFilter filter = new IntentFilter(MyGcmListenerService.ACTION_CHAT);

    BroadcastReceiver mChatReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long sid = intent.getLongExtra(MyGcmListenerService.EXTRA_SENDER_ID, 0);
            if (sid == user.id) {
                runOnUiThread(initRunnable);
                intent.putExtra(MyGcmListenerService.EXTRA_RESULT, true);
                return;
            }
        }
    };

    Runnable initRunnable = new Runnable() {
        @Override
        public void run() {
            initData();
        }
    };
    User user;
    long userid = DataManager.INVALID_ID;
    private void initData() {
        if (userid == DataManager.INVALID_ID) {
            userid = DataManager.getInstance().getChatUserId(user.id);
            if (userid == DataManager.INVALID_ID) {
                return;
            }
        }
        Cursor c = DataManager.getInstance().getChatList(userid);
        mAdapter.changeCursor(c);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.changeCursor(null);
    }
}