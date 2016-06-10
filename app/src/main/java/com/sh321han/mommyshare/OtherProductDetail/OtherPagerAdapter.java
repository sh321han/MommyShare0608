package com.sh321han.mommyshare.OtherProductDetail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016-05-24.
 */
public class OtherPagerAdapter extends PagerAdapter {

    private static final String MOMMYSHARE_SERVER = "http://52.79.57.157:3000";

    Context mContext;



    public OtherPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 0;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = null;


        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }




}
