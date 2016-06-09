package com.sh321han.mommyshare.MyProductDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sh321han.mommyshare.Main.MainActivity;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.MyProductDetailData;
import com.sh321han.mommyshare.data.ProductDetailData;

public class MyProductDetailActivity extends AppCompatActivity {

    int home = 0;
    RecyclerView recyclerView;
    MyProductDetailAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    MyProductDetailData data;

    String name;
    int rent_fee, rent_deposit, min_rent_period, max_rent_period;
    String content;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_product_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        content = intent.getStringExtra("content");
        name = intent.getStringExtra("name");
        rent_fee = intent.getExtras().getInt("rent_fee");
        rent_deposit = intent.getExtras().getInt("rent_deposit");
        min_rent_period = intent.getExtras().getInt("min_rent_period");
        max_rent_period = intent.getExtras().getInt("max_rent_period");
        category = intent.getStringExtra("category");
        home = intent.getExtras().getInt("home");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new MyProductDetailAdapter();
        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initData();
    }

    private void initData() {

        //네트워크 매니저를 받아온 데이터

        //네트워크 매니저를 받아온 데이터
        ProductDetailData data = new ProductDetailData();
        data.setName(name);
        data.setRent_fee(rent_fee);
        data.setRent_deposit(rent_deposit);
        data.setMin_rent_period(min_rent_period);
        data.setMax_rent_period(max_rent_period);
        data.setCategory(category);
        data.setContent(content);

        mAdapter.add(data);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {

            switch (home) {
                case 0:
                    finish();
                    break;

                case 1:
                    Intent i = new Intent(MyProductDetailActivity.this, MainActivity.class);
                    startActivity(i);
                    break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}