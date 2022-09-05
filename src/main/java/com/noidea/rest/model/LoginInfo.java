package com.noidea.rest.model;

public class LoginInfo {
    private String userid;
    private String password;

    public LoginInfo() {
    }

    public LoginInfo(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public String getuserid() {
        return userid;
    }

    public void setuserid(String userId) {
        this.userid = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
