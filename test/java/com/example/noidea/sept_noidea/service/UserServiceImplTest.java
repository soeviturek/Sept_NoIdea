package com.example.noidea.sept_noidea.service;

import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Autowired
    private MockMvc mvc;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl service;
    @Test
    void loadUserByUsername() {
    }

    @Test
    void getUser() {

        UserDao user = new UserDao();
        user.setUserid(1);
        user.setUsername("abc");
        user.setEmail("123@134");
        user.setMobile("1111111111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        System.out.print(user);
        assertEquals(user,service.getUser(1));

    }

    @Test
    void getUserByUsername() {
        User user = new User(1,"abc","123",0,"123@134","1111111111",0);
        UserDao user1 = new UserDao();
        user1.setUserid(1);
        user1.setUsername("abc");
        user1.setEmail("123@134");
        user1.setMobile("1111111111");
        user1.setPassword("123");
        user1.setDeleteFlag(0);
        user1.setUserType(1) ;
        when(userRepository.findByUsername("abc")).thenReturn(Optional.<User>of(user));
        assertNotNull(user);
        assertThat(user.getUsername()).isNotEqualTo(null);
    }

    @Test
    void getAllUser() {
        User user = new User();
        user.setUserid(1);
        user.setEmail("123@123");
        user.setMobile("1111-111-111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        //userRepository.save(user);

        assertEquals(1,service.getAllUser().size());
    }
    @Test
    void getAllUser1() {

        when(userRepository.findAll()).thenReturn(Stream.of(new User(1,"abc","123",0,"123@134","1111111111",0),new User(2,"abcd","1234",0,"1253@134","1311111111",0)).collect(Collectors.toList()));
            assertNotNull(userRepository);
            assertEquals(2,service.getAllUser().size());




    }

    @Test
    void addUser() {
        User user = new User(1,"abc","123",0,"123@134","1111111111",0);
        UserDao user1 = new UserDao();
        user1.setUserid(1);
        user1.setUsername("abc");
        user1.setEmail("123@134");
        user1.setMobile("1111111111");
        user1.setPassword("123");
        user1.setDeleteFlag(0);
        user1.setUserType(0) ;
        System.out.println(user1);
        UserNewDao user2 = service.addUser(user1);
        assertNotNull(user2);
        assertThat(user2.getUsername()).isEqualTo("abc");

    }
    @Test
    void create(){
        User user = new User(1,"abc","123",0,"123@134","1111111111",0);
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user.getUserid(),userRepository.save(user).getUserid());


    }








}