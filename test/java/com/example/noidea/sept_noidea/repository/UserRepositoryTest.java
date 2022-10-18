package com.example.noidea.sept_noidea.repository;

import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;


    private UserDao userDao;
    private UserServiceImpl service;
    @BeforeEach
    void init() {


    }
    @Test
    void findAll() {
        User user = new User(1,"abc","123",1,"123@134","1111111111",0);
        userRepository.save(user);


        Iterable<User> list = userRepository.findAll();

        assertNotNull(list);
        assertThat(list).isNotNull();
        //assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void findBy() {
        User user = new User(1,"abc","123",1,"123@134","1111111111",0);
        userRepository.save(user);

        User newuser = userRepository.findBy(user.getUserid()).get();

        assertNotNull(newuser);
        assertEquals("abc", user.getUsername());
        assertEquals("123", user.getPassword());
        assertEquals(1, user.getUserType());
        assertEquals("11111111111", user.getMobile());

    }

    @Test
    void findByUsername() {
        User user = new User(1,"abc","123",1,"123@134","1111111111",0);
        userRepository.save(user);
        Optional<User> list = userRepository.findByUsername("abc");
        assertNotNull(list);

    }
}