package com.sh321han.mommyshare.OtherProductDetail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;

/**
 * Created by Administrator on 2016-05-24.
 */
public class OtherPagerAdapter extends PagerAdapter {

    private static final String MOMMYSHARE_SERVER = "http://52.79.57.157:3000";
    LayoutInflater inflater;
    ProductDetailData data;
    Context mContext;
    public static final int VIEW_COUNT = 3;


    public OtherPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return VIEW_COUNT;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = null;
        view= inflater.inflate(R.layout.viewpager_childview, null);
        ImageView img = (ImageView)view.findViewById(R.id.image_profile);
        Glide.with(view.getContext()).load(MOMMYSHARE_SERVER + data.getPicture_path() + data.getPicture_name().get(0)).into(img);
        container.addView(view);

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
