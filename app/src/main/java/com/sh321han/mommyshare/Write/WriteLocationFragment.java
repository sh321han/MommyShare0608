package com.sh321han.mommyshare.Write;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sh321han.mommyshare.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WriteLocationFragment extends Fragment {


    public WriteLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Toast.makeText(getActivity(), getArguments().getString("name"), Toast.LENGTH_LONG).show();




        Button buttn = (Button)getActivity().findViewById(R.id.btn_next);

        buttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle  b = new Bundle();
                b.putString("name",getArguments().getString("name"));
                WriteDetailFragment nextFragment = new WriteDetailFragment();
                nextFragment.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.container, nextFragment).commit();
            }
        });


        return inflater.inflate(R.layout.fragment_write_location, container, false);
    }

}
