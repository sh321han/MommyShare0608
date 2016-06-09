package com.sh321han.mommyshare.data;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016-05-21.
 */
public class MyProductDetailData {

//    public static final int TYPE_DESC = 0;
//    public static final int TYPE_DETAIL = 1;
//    public static final int TYPE_REVIEW = 2;

    String product_name;
    int price;
    int deposit;
    int period;
    String location;
    String detail;
    Drawable review_profile;
    String review_name;
    String review_time;
    String review_content;
    Drawable pager_image1, pager_image2, pager_image3;

    public Drawable getPager_image1() {
        return pager_image1;
    }

    public void setPager_image1(Drawable pager_image1) {
        this.pager_image1 = pager_image1;
    }

    public Drawable getPager_image2() {
        return pager_image2;
    }

    public void setPager_image2(Drawable pager_image2) {
        this.pager_image2 = pager_image2;
    }

    public Drawable getPager_image3() {
        return pager_image3;
    }

    public void setPager_image3(Drawable pager_image3) {
        this.pager_image3 = pager_image3;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Drawable getReview_profile() {
        return review_profile;
    }

    public void setReview_profile(Drawable review_profile) {
        this.review_profile = review_profile;
    }

    public String getReview_name() {
        return review_name;
    }

    public void setReview_name(String review_name) {
        this.review_name = review_name;
    }

    public String getReview_time() {
        return review_time;
    }

    public void setReview_time(String review_time) {
        this.review_time = review_time;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }
}
