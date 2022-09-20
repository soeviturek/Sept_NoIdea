package com.noidea.rest.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    private String password;
    private int userType;
    private String email;
    private String mobile;
    private int deleteFlag;

    public User() {
    }

    public User(int userid, String password, int userType, String email, String mobile, int deleteFlag) {
        this.userid = userid;
        this.password = password;
        this.userType = userType;
        this.email = email;
        this.mobile = mobile;
        this.deleteFlag = deleteFlag;
    }

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

