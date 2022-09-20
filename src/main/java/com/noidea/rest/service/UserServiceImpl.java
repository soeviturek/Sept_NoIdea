package com.noidea.rest.service;

import com.noidea.rest.dao.UserDao;
import com.noidea.rest.dao.UserExistingDao;
import com.noidea.rest.dao.UserNewDao;
import com.noidea.rest.dao.UserRepository;
import com.noidea.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository ur;
    private List<User> userList;

    @Override
    public UserDao getUser(int id){

        Optional<User> userOpt = ur.findById(id);
        if (!userOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        User user = userOpt.get();

        UserDao userDao = new UserDao();
        userDao.setUserid(user.getUserid());
        userDao.setPassword(user.getPassword());
        userDao.setEmail(user.getEmail());
        userDao.setUserType(user.getUserType());
        userDao.setMobile(user.getMobile());
        userDao.setDeleteFlag(user.getDeleteFlag());
        return userDao;

    }
    @Override
    public List<UserDao> getAllUser(Pageable pageable) {
//        ur.findAll(pageable);
        Page<User> userPage = ur.findAll(pageable);

        List<UserDao> userDaoList = new ArrayList<>();
//        Page<UserDao> userDaoPage = new PageImpl<>(userDaoList,pageable,0);

        if (!userPage.isEmpty()) {

            userPage.getContent().forEach(user -> {
                UserDao userDao = new UserDao();
                userDao.setUserid(user.getUserid());
                userDao.setPassword(user.getPassword());
                userDao.setEmail(user.getEmail());
                userDao.setUserType(user.getUserType());
                userDao.setMobile(user.getMobile());
                userDao.setDeleteFlag(user.getDeleteFlag());

                userDaoList.add(userDao);
            });
//            userDaoPage = new PageImpl<>(userDaoList, pageable, userPage.getTotalElements());
        }
        return userDaoList;
    }

    @Override
    public UserNewDao addUser(UserDao u) {
        User user = new User();
        user.setUserid(u.getUserid());
        user.setPassword(u.getPassword());
        user.setEmail(u.getEmail());
        user.setUserType(u.getUserType());
        user.setMobile(u.getMobile());
        user.setDeleteFlag(u.getDeleteFlag());
        user = ur.save(user);
        UserNewDao ud = new UserNewDao();
        ud.setUserid(u.getUserid());
        ud.setPassword(u.getPassword());
        ud.setEmail(u.getEmail());
        ud.setUserType(u.getUserType());
        ud.setMobile(u.getMobile());
        ud.setDeleteFlag(u.getDeleteFlag());
        return ud;
    }

}
