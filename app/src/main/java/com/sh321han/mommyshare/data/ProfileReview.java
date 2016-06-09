package com.sh321han.mommyshare.data;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016-05-19.
 */
public class ProfileReview {
    private String name;
    private String time;
    private String review;
    private Drawable profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Drawable getProfile() {
        return profile;
    }

    public void setProfile(Drawable profile) {
        this.profile = profile;
    }
}
