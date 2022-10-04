package com.example.noidea.sept_noidea.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.model.LoginInfo;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/users")
public class RegisterController {
    @Autowired
    private UserServiceImpl userDao;
    //get all users api
    @GetMapping("/all_users")
    public ResponseEntity<Object> getAllUsers() {
        List<UserDao> userList = userDao.getAllUser();
        return ResponseEntity.ok().header("OK!").body(userList);
    }
    //create
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody UserDao user){
        User check = userDao.getUserByUsername(user.getUsername());
        if(check != null){
            return ResponseEntity.badRequest().body("Username already exists!");
        }
        if(user.getUserType() == 1 || user.getUserType() == 2){
            return ResponseEntity.badRequest().body("No permission to create advanced user types!");
        }
        userDao.addUser(user);
        return ResponseEntity.ok("Created!");
    }
    //create
    @PostMapping("/createdoc")
    public ResponseEntity<Object> createDoctor(@RequestBody UserDao user){
//        UserDao admin = userDao.getUser(uid);
//        if(admin == null || admin.getUserType() != 2){
//            return ResponseEntity.badRequest().body("No permission to create doctors!");
//        }
//        if(user.getUserType() != 1){
//            return ResponseEntity.badRequest().body("Given user type is not doctor!");
//        }
        //check for username
        User check = userDao.getUserByUsername(user.getUsername());
        if(check != null){
            return ResponseEntity.badRequest().body("Username already exists!");
        }

        userDao.addUser(user);
        return ResponseEntity.ok("Created!");
    }
    //get by username
    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Object> getUserbyId(@PathVariable("id") int id){
        UserDao user = userDao.getUser(id);
        return ResponseEntity.ok().body(user);
    }
    //update
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateUser(@PathVariable(name = "id") int id, @RequestBody User updateUser){
        UserDao user = userDao.getUser(id);
        user.setEmail(updateUser.getEmail());
        user.setMobile(updateUser.getMobile());
        user.setPassword(updateUser.getPassword());
        UserNewDao updatedEmployee = userDao.addUser(user);
        return ResponseEntity.ok("Updated!");
    }
    //delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteUser(@PathVariable int id){
        UserDao user= userDao.getUser(id);
        user.setDeleteFlag(1);
        UserNewDao updatedEmployee = userDao.addUser(user);
        return ResponseEntity.ok("Deleted");
    }

}
