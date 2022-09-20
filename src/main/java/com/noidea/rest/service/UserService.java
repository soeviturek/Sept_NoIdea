package com.noidea.rest.service;

import com.noidea.rest.dao.UserDao;
import com.noidea.rest.dao.UserExistingDao;
import com.noidea.rest.dao.UserNewDao;
import com.noidea.rest.model.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;


public interface UserService {

    UserNewDao addUser(UserDao user);


//    void deleteStudent(Integer studentId);
//
    UserDao getUser(int id);

    List<UserDao> getAllUser(Pageable pageable);


}
