package com.sh321han.mommyshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.sh321han.mommyshare.Main.MainActivity;
import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.Manager.PropertyManager;

import java.io.IOException;
import java.util.Arrays;

import okhttp3.Request;

public class LoginActivity extends AppCompatActivity {

    CallbackManager callbackManager;
//    SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        mPref = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        /*mPref.getString("")*/
//        int x = mPref.getInt("member_id", 0);


        callbackManager = CallbackManager.Factory.create();

        Button btn = (Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccessToken token = AccessToken.getCurrentAccessToken();
                if (token != null) {
                    LoginManager.getInstance().logOut();
//                    SharedPreferences.Editor editor =  mPref.edit();
//                    editor.remove("memeber_id");
                }
                if (token == null) {
                    LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            AccessToken token = AccessToken.getCurrentAccessToken();
                            NetworkManager.getInstance().login(LoginActivity.this, token.getToken(), PropertyManager.getInstance().getRegistrationToken(), new NetworkManager.OnResultListener<com.sh321han.mommyshare.data.LoginResult>() {
                                @Override
                                public void onSuccess(Request request, com.sh321han.mommyshare.data.LoginResult result) {
                                    if (result.getSuccess()) {
                                        if (result.getMessage().equals("OK")) {
                                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                                            SharedPreferences.Editor editor =  mPref.edit();
//                                            editor.putInt("member_id", result.getResult().getMember_id());
                                                //editor.commit();


                                        } else if (result.getMessage().equals("NOTREGISTER")) {

                                            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                                        }
                                    }
                                }

                                @Override
                                public void onFail(Request request, IOException exception) {
                                    Log.d("실패","ㅇㅇㅇ");
                                }
                            });
                        }

                        @Override
                        public void onCancel() {

                        }

                        @Override
                        public void onError(FacebookException error) {

                        }
                    });

                    LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("email"));
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
