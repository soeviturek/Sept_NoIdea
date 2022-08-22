package com.example.demo.entity;


import javax.persistence.Entity;

@Entity
public class User {

    private String userid;
    private String password;
    private String userType;
    private String email;
    private String mobile;
    private String deleteFlag;
}
