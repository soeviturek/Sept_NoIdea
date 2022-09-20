package com.noidea.rest.dao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserNewDao {
    @NotNull(message = "id cannot be empty")
    private int userid;
    @NotNull(message = "Password cannot be empty")
    @Size(min = 2, max = 15,
            message = "Password must be at least of 2 letters and not more then 100 letters")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email
    private String email;

    private int userType;
    private String mobile;
    private int deleteFlag;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
}
