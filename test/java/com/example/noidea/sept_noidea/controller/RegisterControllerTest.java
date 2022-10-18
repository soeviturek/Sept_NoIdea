package com.example.noidea.sept_noidea.controller;

import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.repository.UserRepository;
import com.example.noidea.sept_noidea.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RegisterController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)

class RegisterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    @Autowired
    private ObjectMapper objectMapper;

    private UserDao userDao;
    private UserRepository userRepository;

    @Test
    void getAllUsers() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setEmail("123@123");
        user.setMobile("1111-111-111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        user.setUsername("abc");

        try {
            mockMvc.perform(get("/api/users/all_users").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.userid").exists())
                    .andExpect(jsonPath("$.email").exists())
                    .andExpect(jsonPath("$.mobile").exists())
                    .andExpect(jsonPath("$.password").exists())
                    .andExpect(jsonPath("$.userType").exists())
                    .andDo(print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        verify(userService).addUser(user);
    }

    @Test
    void createUser() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setEmail("123@123");
        user.setMobile("1111-111-111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        user.setUsername("abc");
        given(userService.addUser(Mockito.any())).willReturn(userService.addUser(user));
        try {
            mockMvc.perform(post("/api/users/create").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id",is(1)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        verify(userService, VerificationModeFactory.times(1));
        reset(userService);
    }

    @Test
    void createDoctor() {
    }

    @Test
    void getUserbyId() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setEmail("123@123");
        user.setMobile("1111-111-111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        user.setUsername("abc");

    }

    @Test
    void updateUser() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setEmail("123@123");
        user.setMobile("1111-111-111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        user.setUsername("abc");
        UserDao user1 = userService.getUser(1);
        user.setEmail("356@346");
        user.setMobile("1111111113");
        user.setPassword("3678");
        UserNewDao updatedEmployee = userService.addUser(user);

        try {
            this.mockMvc.perform(put("api/users/update/{id}", 1L)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(user)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(user.getUsername())))
                    .andExpect(jsonPath("$.id", is(user.getUserid())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void deleteUser() throws Exception {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setEmail("123@123");
        user.setMobile("1111-111-111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setUserType(1) ;
        user.setUsername("abc");
        UserDao users= userService.getUser(1);

        UserNewDao updatedEmployee = userService.addUser(user);
        user.setDeleteFlag(1);
        this.mockMvc.perform(delete("/users/delete/{id}", 1))
                .andExpect(status().isNoContent());
    }
}