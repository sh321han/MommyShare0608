package com.sh321han.mommyshare.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProfileReview;

public class OtherProfileActivity extends AppCompatActivity {

    ListView listView;
    ProfileReviewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView)findViewById(R.id.listview);

        View header_1 = getLayoutInflater().inflate(R.layout.view_other_profile_header_1, null, false);
        View header_2 = getLayoutInflater().inflate(R.layout.view_profile_header_2, null, false);
        View header_3 = getLayoutInflater().inflate(R.layout.view_other_profile_header_3, null, false);
        View footer = getLayoutInflater().inflate(R.layout.view_profile_footer, null, false);
        listView.addHeaderView(header_1);
        listView.addHeaderView(header_2);
        listView.addHeaderView(header_3);
        listView.addFooterView(footer);

        mAdapter = new ProfileReviewAdapter();
        mAdapter.setOnAdapterItemClickListener(new ProfileReviewAdapter.OnAdapterItemClickListener() {
            @Override
            public void onItemImageClick(ProfileReviewAdapter apdater, ProfileReviewView view, ProfileReview myprofile) {
//                Toast.makeText(OtherProfileActivity.this, "item image click : " + myprofile.getName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(OtherProfileActivity.this, OtherProfileActivity.class);
                startActivity(i);
            }
        });

        mAdapter.setOnImageClickListener(new ProfileReviewView.OnImageClickListener() {
            @Override
            public void onImageClick(ProfileReviewView view, ProfileReview profile) {
//                Toast.makeText(OtherProfileActivity.this, "item image click : " + profile.getName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(OtherProfileActivity.this, OtherProfileActivity.class);
                startActivity(i);
            }
        });
        listView.setAdapter(mAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ProfileReview p = (ProfileReview) listView.getItemAtPosition(position);
//                Toast.makeText(OtherProfileActivity.this, "person : " + p.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

        initData();
    }

    private void initData() {
        for (int i = 0 ; i < 10 ; i++) {
            ProfileReview p = new ProfileReview();
            p.setName("Name" + i);
            p.setTime("Time" + i);
            p.setReview("Review" + i);
            p.setProfile(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
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
