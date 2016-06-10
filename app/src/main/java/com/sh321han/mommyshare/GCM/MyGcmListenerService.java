/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sh321han.mommyshare.GCM;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;
import com.sh321han.mommyshare.Main.MainActivity;
import com.sh321han.mommyshare.Manager.DataConstant;
import com.sh321han.mommyshare.Manager.DataManager;
import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.MyResult;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.User;
import com.sh321han.mommyshare.data.ChatMessage;

import java.io.IOException;
import java.util.List;

public class MyGcmListenerService extends GcmListenerService {

    private static final String TAG = "MyGcmListenerService";

    public static final String ACTION_CHAT = "com.sh321han.mommyshare.action.chat";
    public static final String EXTRA_SENDER_ID = "senderid";
    public static final String EXTRA_RESULT = "result";

    /**
     * Called when message is received.
     *
     * @param from SenderID of the sender.
     * @param data Data bundle containing message data as key/value pairs.
     *             For Set of keys use data.keySet().
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(String from, Bundle data) {
        String type = data.getString("type");
        String senderid = data.getString("sender");
        String title = data.getString("title");
        Log.d(TAG, "Type: " + type);
        Log.d(TAG, "From: " + from);
        Log.d(TAG, "senderid: " + senderid);
        Log.d(TAG, "Title: " + title);

        if (from.startsWith("/topics/")) {
            // message received from some topic.
        } else {

            // normal downstream message.

            if (type.equals("chat")) {
                long serverid = -1L;
                String lastDate = DataManager.getInstance().getLastDate();
                try {
                    MyResult<List<ChatMessage>> result = NetworkManager.getInstance().getMessageSync(lastDate);
                    String notiMessage = null;
                    User u = null;
                    for (ChatMessage m : result.result) {
                        long id = DataManager.getInstance().getUserTableId(m.sender);
                        DataManager.getInstance().addChatMessage(id, DataConstant.ChatTable.TYPE_RECEIVE, m.message, m.date);
                        notiMessage = m.sender.userName + ":" + m.message;
                        u = m.sender;
                        serverid = id;
                    }
                    Intent intent = new Intent(ACTION_CHAT);
                    intent.putExtra(EXTRA_SENDER_ID, serverid);
                    LocalBroadcastManager.getInstance(this).sendBroadcastSync(intent);
                    boolean isProcessed = intent.getBooleanExtra(EXTRA_RESULT, false);
                    if (!isProcessed) {
                        sendNotification(notiMessage, u);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // [START_EXCLUDE]
        /**
         * Production applications would usually process the message here.
         * Eg: - Syncing with server.
         *     - Store message in local database.
         *     - Update UI.
         */

        /**
         * In some cases it may be useful to show a notification indicating to the user
         * that a message was received.
         */

//        sendNotification(title);
        // [END_EXCLUDE]
    }
    // [END receive_message]

    /**
     * Create and show a simple notification containing the received GCM message.
     *
     * @param title GCM message received.
     */
    private void sendNotification(String title, User user) {
        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra(ChattingActivity.EXTRA_USER, user);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setTicker(title)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("MommyShare")
                .setContentText(title)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}
