package com.sh321han.mommyshare.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-15.
 */
public class MainProduct {

    public String _id; //상품아이디
    public String category_id;
    public String name; // 상품 이름
    //public String[] picture_name;
    public List<String> picture_name = new ArrayList<String>();

    public String picture_path;
    public int rent_fee;
    public int rent_deposit;
    public String min_rent_period;
    public String max_rent_period;
    public String location;
    public String content;
    public String status;
    public String rending_member;
    public String[] reviews;

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



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMin_rent_period() {
        return min_rent_period;
    }

    public void setMin_rent_period(String min_rent_period) {
        this.min_rent_period = min_rent_period;
    }

    public String getMax_rent_period() {
        return max_rent_period;
    }

    public void setMax_rent_period(String max_rent_period) {
        this.max_rent_period = max_rent_period;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
