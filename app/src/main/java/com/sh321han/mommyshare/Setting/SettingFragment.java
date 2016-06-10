package com.sh321han.mommyshare.Setting;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sh321han.mommyshare.MyApplication;
import com.sh321han.mommyshare.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    TextView setting1, setting5, setting2, setting3, setting4;
    SharedPreferences mPref;


    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPref = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        setting1 = (TextView) view.findViewById(R.id.setting1);
        setting2 = (TextView) view.findViewById(R.id.setting2);
        setting3 = (TextView) view.findViewById(R.id.setting3);
        setting4 = (TextView) view.findViewById(R.id.setting4);

        setting3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("로그아웃?");
                builder.setMessage("하겠습니까?");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Yes Clicked", Toast.LENGTH_LONG).show();
//                        SharedPreferences.Editor editor =  mPref.edit();
//                        editor.remove("memeber_id");
//                        Intent i = new Intent(getContext(), LoginActivity.class);
//                        startActivity(i);

                    }
                });
                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        setting4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("회원탈퇴?");
                builder.setMessage("하겠습니까?");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Yes Clicked", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });



        return view;
    }
}
