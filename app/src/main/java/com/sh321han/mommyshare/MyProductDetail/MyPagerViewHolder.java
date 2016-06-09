package com.sh321han.mommyshare.MyProductDetail;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.MyProductDetailData;

/**
 * Created by Tacademy on 2016-05-24.
 */
public class MyPagerViewHolder extends RecyclerView.ViewHolder {

    PagerAdapter mAdapter;
    ViewPager pager;
    MyProductDetailData data;

    public MyPagerViewHolder(View itemView) {
        super(itemView);

        pager = (ViewPager)itemView.findViewById(R.id.pager);
        mAdapter = new MyPagerAdapter(itemView.getContext());
        pager.setAdapter(mAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void setData(MyProductDetailData data) {
        this.data = data;
    }
}
