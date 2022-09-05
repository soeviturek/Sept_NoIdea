package com.noidea.rest.model;

public class User {

    private String userid;
    private String password;
    private String userType;
    private String email;
    private String mobile;
    private String deleteFlag;

    public User() {
    }

    public User(String userid, String password, String userType, String email, String mobile, String deleteFlag) {
        this.userid = userid;
        this.password = password;
        this.userType = userType;
        this.email = email;
        this.mobile = mobile;
        this.deleteFlag = deleteFlag;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                '}';
    }
}

