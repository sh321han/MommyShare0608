//package com.sh321han.mommyshare.Main;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Spinner;
//
//import com.sh321han.mommyshare.R;
//
///**
// * Created by Tacademy on 2016-05-24.
// */
//public class MainSpinnerViewHolder extends RecyclerView.ViewHolder {
//
//    Spinner spinner1, spinner2, spinner3;
//    ArrayAdapter categoryAdapter, priceAdapter, distAdapter;
//
//
//
//    public MainSpinnerViewHolder(View itemView) {
//        super(itemView);
//        spinner1 = (Spinner)itemView.findViewById(R.id.spinner1);
//        spinner2 = (Spinner)itemView.findViewById(R.id.spinner2);
//        spinner3 = (Spinner)itemView.findViewById(R.id.spinner3);
//
//        categoryAdapter = ArrayAdapter.createFromResource(itemView.getContext(), R.array.category_item, android.R.layout.simple_spinner_item);
//        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner1.setAdapter(categoryAdapter);
//        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        priceAdapter = ArrayAdapter.createFromResource(itemView.getContext(), R.array.price_item, android.R.layout.simple_spinner_item);
//        priceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(priceAdapter);
//        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        distAdapter = ArrayAdapter.createFromResource(itemView.getContext(), R.array.dist_item, android.R.layout.simple_spinner_item);
//        distAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner3.setAdapter(distAdapter);
//        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//     }
//}
//
//
//
