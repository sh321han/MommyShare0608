package com.sh321han.mommyshare.Write;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class WriteFragment extends Fragment {

    EditText edit_name, edit_price, edit_deposit, edit_max_period, edit_min_period;

    Spinner sp;

    List<String> categoryList = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    String category;
    String ok;
    double locX, locY;

    private static final int RESULT = 0;

    public WriteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setCategory();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_write, container, false);

        edit_name = (EditText) v.findViewById(R.id.edit_name);
        edit_price = (EditText) v.findViewById(R.id.edit_price);
        edit_deposit = (EditText) v.findViewById(R.id.edit_deposit);
        edit_max_period = (EditText) v.findViewById(R.id.edit_max_period);
        edit_min_period = (EditText) v.findViewById(R.id.edit_min_period);

        sp = (Spinner) v.findViewById(R.id.spinner);


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), categoryList.get(position), Toast.LENGTH_LONG).show();
                category = categoryList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button btn = (Button) getActivity().findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle  b = new Bundle();
//                b.putString("name",edit_name.getText().toString());
//                b.putInt("rent_fee", Integer.parseInt(edit_price.getText().toString()));
//                b.putInt("rent_deposit", Integer.parseInt(edit_deposit.getText().toString()));
//                b.putInt("min_rent_period", Integer.parseInt(edit_min_period.getText().toString()));
//                b.putInt("max_rent_period", Integer.parseInt(edit_max_period.getText().toString()));
//                b.putString("category", category.toString());


                Intent i = new Intent(getActivity(), WriteLocationActivity.class);

//                i.putExtra("name", edit_name.getText().toString());
//                i.putExtra("category", category.toString());
//                i.putExtra("rent_fee", Integer.parseInt(edit_price.getText().toString()));
//                i.putExtra("rent_deposit", Integer.parseInt(edit_deposit.getText().toString()));
//                i.putExtra("min_rent_period", Integer.parseInt(edit_min_period.getText().toString()));
//                i.putExtra("max_rent_period", Integer.parseInt(edit_max_period.getText().toString()));

                startActivityForResult(i, RESULT);

//                WriteDetailFragment nextFragment = new WriteDetailFragment();
//                nextFragment.setArguments(b);
//                getFragmentManager().beginTransaction().replace(R.id.container, nextFragment).commit();
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT:
                if (resultCode == getActivity().RESULT_OK) {

                    Bundle bundle = data.getExtras();
                    locX = data.getDoubleExtra(WriteLocationActivity.RESULT_LOCX, locX);
                    locY = data.getDoubleExtra(WriteLocationActivity.RESULT_LOCY, locY);



                    Bundle b = new Bundle();
                    b.putString("name", edit_name.getText().toString());
                    b.putInt("rent_fee", Integer.parseInt(edit_price.getText().toString()));
                    b.putInt("rent_deposit", Integer.parseInt(edit_deposit.getText().toString()));
                    b.putInt("min_rent_period", Integer.parseInt(edit_min_period.getText().toString()));
                    b.putInt("max_rent_period", Integer.parseInt(edit_max_period.getText().toString()));
                    b.putString("category", category.toString());
                    b.putDouble("longitude", locX);
                    b.putDouble("latitude", locY);

                    WriteDetailFragment nextFragment = new WriteDetailFragment();
                    nextFragment.setArguments(b);
                    getFragmentManager().beginTransaction().replace(R.id.container, nextFragment).addToBackStack(null).commit();

                }
                break;
        }

//        if(ok == "ok") {
//            getFragmentManager().beginTransaction().replace(R.id.container, new WriteDetailFragment()).addToBackStack(null).commit();
//
//        }
    }

    private void setCategory() {
        NetworkManager.getInstance().getCategoryList(this, new NetworkManager.OnResultListener<List<String>>() {
            @Override
            public void onSuccess(Request request, List<String> result) {
                categoryList = result;

                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categoryList);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                sp.setAdapter(adapter);
            }

            @Override
            public void onFail(Request request, IOException exception) {

            }
        });
    }

}
