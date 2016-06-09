package com.sh321han.mommyshare.MyProductDetail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class MyPagerAdapter extends PagerAdapter{

    Context mContext;
    public static final int VIEW_COUNT = 3;

    public MyPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return VIEW_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView v = new TextView(mContext);
        v.setText("position" + position);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View v = (View)object;
        container.removeView(v);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
