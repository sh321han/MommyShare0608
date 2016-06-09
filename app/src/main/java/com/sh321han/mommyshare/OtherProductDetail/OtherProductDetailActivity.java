package com.sh321han.mommyshare.OtherProductDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;
import com.sh321han.mommyshare.data.ProductReviewWrite;

import java.io.IOException;

import okhttp3.Request;

public class OtherProductDetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OtherProductDetailAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_product_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.before_icon);
        getSupportActionBar().setDisplayShowTitleEnabled(true);




        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        initData(id);




        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new OtherProductDetailAdapter();


        mAdapter.setClickButtonListener(new OtherWriteViewHolder.OnClickButtonListener() {
            @Override
            public void onClickBtn(View v, EditText etText) {

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(etText.getWindowToken(), 0);

                NetworkManager.getInstance().ProductReviewWrite(id, etText.getText().toString(), new NetworkManager.OnResultListener<ProductReviewWrite>() {
                    @Override
                    public void onSuccess(Request request, ProductReviewWrite result) {
                        if (result.success.equals("true")) {

                            initData(id);

                        } else {

                        }
                    }

                    @Override
                    public void onFail(Request request, IOException exception) {

                    }
                });

                etText.setText("");

            }
        });

        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        initData(id);
//
//    }

    private void initData(String id) {


        NetworkManager.getInstance().ProductDetail(id, new NetworkManager.OnResultListener<ProductDetailData>() {
            @Override
            public void onSuccess(Request request, ProductDetailData result) {
//                mAdapter.clear();
                mAdapter.set(result);

            }

            @Override
            public void onFail(Request request, IOException exception) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
