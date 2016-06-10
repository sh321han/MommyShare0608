package com.sh321han.mommyshare;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.sh321han.mommyshare.GCM.RegistrationIntentService;
import com.sh321han.mommyshare.Main.MainActivity;
import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.Manager.PropertyManager;
import com.sh321han.mommyshare.data.LoginResult;

import java.io.IOException;

import okhttp3.Request;

public class SplashActivity extends AppCompatActivity {

    Handler mHandler = new Handler(Looper.getMainLooper());
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                doRealStart();
            }
        };
        setUpIfNeeded();

    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(RegistrationIntentService.REGISTRATION_COMPLETE));
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLAY_SERVICES_RESOLUTION_REQUEST &&
                resultCode == Activity.RESULT_OK) {
            setUpIfNeeded();
        }
    }

    private void setUpIfNeeded() {
        if (checkPlayServices()) {
            String regId = PropertyManager.getInstance().getRegistrationToken();
            if (!regId.equals("")) {
                doRealStart();
            } else {
                Intent intent = new Intent(this, RegistrationIntentService.class);
                startService(intent);
            }
        }
    }

    private void doRealStart() {
        AccessToken token = AccessToken.getCurrentAccessToken();
        if (token != null) {
            NetworkManager.getInstance().login(this, token.getToken(), PropertyManager.getInstance().getRegistrationToken(), new NetworkManager.OnResultListener<LoginResult>() {
                @Override
                public void onSuccess(Request request, LoginResult result) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }

                @Override
                public void onFail(Request request, IOException exception) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            });
        } else {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }, 2000);
        }
    }

    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                Dialog dialog = apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST);
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

                    @Override
                    public void onCancel(DialogInterface dialog) {
                        finish();
                    }
                });
                dialog.show();
            } else {
                finish();
            }
            return false;
        }
        return true;
    }

}
