package com.sh321han.mommyshare.Profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProfileReview;

/**
 * Created by Administrator on 2016-05-19.
 */
public class ProfileReviewView extends RelativeLayout {
    public ProfileReviewView(Context context) { this(context, null); }

    ImageView profileView;
    TextView nameView, timeView, reviewView;

    public interface OnImageClickListener {
        public void onImageClick(ProfileReviewView view, ProfileReview myprofile);
    }

    OnImageClickListener mListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mListener = listener;
    }

    public ProfileReviewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.view_profile_review, this);
        profileView = (ImageView)findViewById(R.id.image_profile);
        nameView = (TextView)findViewById(R.id.text_name);
        timeView = (TextView)findViewById(R.id.text_time);
        reviewView = (TextView)findViewById(R.id.text_review);
        profileView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageClick(ProfileReviewView.this, myprofile);
                }
            }
        });
    }

    ProfileReview myprofile;
    public void setMyProfile(ProfileReview d) {
        myprofile = d;
        nameView.setText(d.getName());
        timeView.setText(d.getTime());
        reviewView.setText(d.getReview());
        profileView.setImageDrawable(d.getProfile());
    }
}
