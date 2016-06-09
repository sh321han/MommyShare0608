package com.sh321han.mommyshare.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-05-23.
 */
public class ProductDetailData {

    public String id;
    public String member_name;
    public String member_profile;
    public String name;
    public String picture_path;
    public List<String> picture_name = new ArrayList<String>();
    public int rent_fee;
    public int rent_deposit;
    public int min_rent_period;
    public int max_rent_period;
    public String location;
    public String content;
    public String reg_date;
    public List<ProductReviewData> reviews = new ArrayList<ProductReviewData>();
    public boolean is_keep;
    public String status;
    public String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_profile() {
        return member_profile;
    }

    public void setMember_profile(String member_profile) {
        this.member_profile = member_profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public List<String> getPicture_name() {
        return picture_name;
    }

    public void setPicture_name(List<String> picture_name) {
        this.picture_name = picture_name;
    }

    public int getRent_fee() {
        return rent_fee;
    }

    public void setRent_fee(int rent_fee) {
        this.rent_fee = rent_fee;
    }

    public int getRent_deposit() {
        return rent_deposit;
    }

    public void setRent_deposit(int rent_deposit) {
        this.rent_deposit = rent_deposit;
    }

    public int getMin_rent_period() {
        return min_rent_period;
    }

    public void setMin_rent_period(int min_rent_period) {
        this.min_rent_period = min_rent_period;
    }

    public int getMax_rent_period() {
        return max_rent_period;
    }

    public void setMax_rent_period(int max_rent_period) {
        this.max_rent_period = max_rent_period;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public List<ProductReviewData> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewData> reviews) {
        this.reviews = reviews;
    }

    public boolean is_keep() {
        return is_keep;
    }

    public void setIs_keep(boolean is_keep) {
        this.is_keep = is_keep;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
