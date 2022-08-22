package com.example.demo.entity;

import javax.persistence.Entity;

@Entity
public class Prifile {
    private int id;
    private String userId;
    private String profilePic;
    private String userType;
    private String healthStatus;
    private String deleteFlag;
}
