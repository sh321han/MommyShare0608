package com.sh321han.mommyshare.Write;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sh321han.mommyshare.R;

public class WriteActivity extends AppCompatActivity {

    int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new WriteFragment()).commit();
        }
/*
        Button btn = (Button) findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (count) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new WriteLocationFragment()).commit();
                        count++;
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new WriteDetailFragment()).commit();
                        count++;
                        break;
                    case 2:
                        Intent i = new Intent(WriteActivity.this, MyProductDetailActivity.class);
                        i.putExtra("home", 1);
                        startActivity(i);
                        break;
                    default:
                        break;
                }

            }
        });*/
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.write_toolbar, menu);
//        return true;
//    }


//    @Override
//    public void onBackPressed() {
//        Toast.makeText(this, "ddd", Toast.LENGTH_LONG).show();
//        super.onBackPressed();
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            switch (count) {
                case 0:
                    finish();
                    break;
                case 1:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new WriteFragment()).commit();
                    count--;
                    break;
                case 2:
                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, new WriteLocationFragment()).commit();
                    count--;
                    break;
                default:
                    break;

            }
        }

        return super.onOptionsItemSelected(item);
    }

}



