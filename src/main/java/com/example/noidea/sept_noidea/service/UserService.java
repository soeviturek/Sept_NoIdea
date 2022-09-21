package com.example.noidea.sept_noidea.service;

import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {

    UserNewDao addUser(UserDao user);
    //    void deleteStudent(Integer studentId);
//
    UserDao getUser(int id);

    List<UserDao> getAllUser();


}
