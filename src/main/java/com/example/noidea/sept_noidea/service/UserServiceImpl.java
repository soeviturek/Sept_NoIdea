package com.example.noidea.sept_noidea.service;


import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.repository.UserRepository;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userop = ur.findByUsername(username);
        if(!userop.isPresent()){
            throw new ResourceNotFoundException("User not found!");
        }
        User user = userop.get();
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(Integer.toString(user.getUserType())) );
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public UserDao getUser(int id){

        Optional<User> userOpt = ur.findById(id);
        if (userOpt.isEmpty()) {
            throw new ResourceNotFoundException("user not found");
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
    public User getUserByUsername(String username){
        Optional<User> user = ur.findByUsername(username);
        if(!user.isPresent()){
            throw new ResourceNotFoundException("User not found by username!");
        }
        return user.get();
    }
    @Override
    public List<UserDao> getAllUser() {
        List<User> userPage = (List<User>) ur.findAll();

        List<UserDao> userDaoList = new ArrayList<>();

        if (!userPage.isEmpty()) {

            userPage.forEach(user -> {
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
        //check if the username exists
        Optional<User> check = ur.findByUsername(u.getUsername());
        if (check.isPresent()) {
            throw new ResourceNotFoundException("Username already exists!");
        }

        User user = new User();
        user.setUserid(u.getUserid());
        user.setUsername(u.getUsername());
        user.setPassword(passwordEncoder.encode(u.getPassword())); //encode the password
        user.setEmail(u.getEmail());
        user.setUserType(u.getUserType());
        user.setMobile(u.getMobile());
        user.setDeleteFlag(u.getDeleteFlag());
        user = ur.save(user);
        UserNewDao ud = new UserNewDao();
        ud.setUserid(u.getUserid());
        ud.setPassword(passwordEncoder.encode(u.getPassword()));
        ud.setEmail(u.getEmail());
        ud.setUserType(u.getUserType());
        ud.setMobile(u.getMobile());
        ud.setDeleteFlag(u.getDeleteFlag());
        return ud;
    }

}
