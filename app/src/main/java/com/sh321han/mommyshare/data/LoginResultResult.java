package com.sh321han.mommyshare.data;

public class LoginResultResult {
    private int member_id;
    private String member_channel;
    private String name;
    private String profile_path;
    private String facebook_id;

    public int getMember_id() {
        return this.member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMember_channel() {
        return this.member_channel;
    }

    public void setMember_channel(String member_channel) {
        this.member_channel = member_channel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_path() {
        return this.profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getFacebook_id() {
        return this.facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }
}
