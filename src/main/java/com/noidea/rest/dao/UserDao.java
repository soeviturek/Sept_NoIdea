package com.noidea.rest.dao;
import com.noidea.rest.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import com.noidea.rest.dao.UserRepository;
import java.util.ArrayList;
import java.util.List;


public class UserDao {

    private int userid;
    private String password;
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