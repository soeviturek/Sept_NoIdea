package com.example.noidea.sept_noidea.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void getUserid() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setUsername("abc");
        user.setEmail("123@134");
        user.setMobile("1111111111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        assertNotNull(user.getUserid());
    }

    @Test
    void setUserid() {
        UserDao user = new UserDao();
        user.setUserid(1);
        assertEquals(1,user.getUserid());
    }

    @Test
    void getUsername() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setUsername("abc");
        user.setEmail("123@134");
        user.setMobile("1111111111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        assertNotNull(user.getUsername());
    }

    @Test
    void setUsername() {
        UserDao user = new UserDao();
        user.setUsername("abc");
        assertEquals("abc",user.getUsername());
    }

    @Test
    void getPassword() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setUsername("abc");
        user.setEmail("123@134");
        user.setMobile("1111111111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        assertNotNull(user.getPassword());
    }

    @Test
    void setPassword() {
        UserDao user = new UserDao();
        user.setPassword("123");
        assertEquals("123",user.getUsername());
    }

    @Test
    void getUserType() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setUsername("abc");
        user.setEmail("123@134");
        user.setMobile("1111111111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        assertNotNull(user.getUserType());
    }

    @Test
    void setUserType() {
        UserDao user = new UserDao();
        user.setUserType(1);
        assertEquals(1,user.getUserType());

    }

    @Test
    void getEmail() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setUsername("abc");
        user.setEmail("123@134");
        user.setMobile("1111111111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        assertNotNull(user.getEmail());
    }

    @Test
    void setEmail() {
        UserDao user = new UserDao();
        user.setUsername("123@123");
        assertEquals("123@123",user.getEmail());
    }

    @Test
    void getMobile() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setUsername("abc");
        user.setEmail("123@134");
        user.setMobile("1111111111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        assertNotNull(user.getMobile());
    }

    @Test
    void setMobile() {
        UserDao user = new UserDao();
        user.setMobile("1111111111");
        assertEquals("1111111111",user.getMobile());
    }

    @Test
    void getDeleteFlag() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setUsername("abc");
        user.setEmail("123@134");
        user.setMobile("1111111111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        assertNotNull(user.getDeleteFlag());
    }

    @Test
    void setDeleteFlag() {
        UserDao user = new UserDao();
        user.setDeleteFlag(0);
        assertEquals(0,user.getDeleteFlag());

    }
}