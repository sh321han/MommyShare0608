package com.sh321han.mommyshare.Setting;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh321han.mommyshare.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeDetailFragment extends Fragment {


    public NoticeDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notice_detail, container, false);
    }

}
