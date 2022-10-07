package com.example.noidea.sept_noidea.dao;

public class UserDao {

    private int userid;
    private String password;
    private String username;
    private int userType;
    private String email;
    private String mobile;
    private int deleteFlag;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
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

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "userid=" + userid +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", userType=" + userType +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
