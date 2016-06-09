package com.sh321han.mommyshare.Setting;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.SettingData;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    RecyclerView recyclerView;
    SettingAdapter mAdapter;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mAdapter = new SettingAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter.setOnItemClickListener(new Setting2ViewHolder.OnItemClickListener() {
            @Override
            public void onItemClicked(Setting2ViewHolder holder, View view, SettingData data, int position) {
                Toast.makeText(getContext(), "item clicked", Toast.LENGTH_LONG).show();
            }
        });

        mAdapter.setOnItemClickListener(new Setting3ViewHolder.OnItemClickListener() {
            @Override
            public void onItemClicked(Setting3ViewHolder holder, View view, SettingData data, int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("로그아웃?");
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

        mAdapter.setOnItemClickListener(new Setting4ViewHolder.OnItemClickListener() {
            @Override
            public void onItemClicked(Setting4ViewHolder holder, View view, SettingData data, int position) {
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

        initData();

        return view;
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            SettingData data = new SettingData();
            data.setContent1("푸시알림");
            data.setContent2("공지사항");
            data.setContent3("로그아웃");
            data.setContent4("회원탈퇴");
            data.setContent5("버젼정보");
            mAdapter.add(data);
        }
    }
}
