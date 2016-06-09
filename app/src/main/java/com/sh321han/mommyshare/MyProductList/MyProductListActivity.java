package com.sh321han.mommyshare.MyProductList;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.sh321han.mommyshare.MyProductDetail.MyProductDetailActivity;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.MyProduct;

public class MyProductListActivity extends AppCompatActivity {

    final String[] items = new String[] {"게시물 보기", "게시물 삭제", "게시물 수정", "대여중으로 변경", "대여가능으로 변경"};
    RecyclerView listView;
    MyProductListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_product_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (RecyclerView) findViewById(R.id.my_rv_list);
        mAdapter = new MyProductListAdapter();
        listView.setAdapter(mAdapter);

        listView.setLayoutManager(new GridLayoutManager(this, 2));

        mAdapter.setOnItemClickListener(new MyProductListViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, MyProduct myproduct) {
                editDialog();
            }
        });
        setData();





    }

    private void editDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyProductListActivity.this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyProductListActivity.this, items[which], Toast.LENGTH_LONG).show();
                switch(which) {
                    case 0 :
                        Intent i = new Intent(MyProductListActivity.this, MyProductDetailActivity.class);
                        i.putExtra("home", 0);
                        startActivity(i);
                }
            }
        });
        AlertDialog dialog = builder.create();
        ListView listView = dialog.getListView();
        dialog.show();
    }

    private void setData() {
        for (int i = 0; i < 10; i++) {
            MyProduct p = new MyProduct();
            p.setMy_name("Name " + i);
            p.setMy_price(i);
            p.setMy_deposit(i);
            p.setMy_minPeriod(i);
            p.setMy_minPeriod(i);
            mAdapter.add(p);
        }
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
