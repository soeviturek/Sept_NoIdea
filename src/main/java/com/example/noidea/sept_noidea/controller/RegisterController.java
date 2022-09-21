package com.example.noidea.sept_noidea.controller;

import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.model.LoginInfo;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

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
    //login
    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity<Object> login(@RequestBody LoginInfo info){
        UserDao user = userDao.getUser(Integer.parseInt(info.getuserid()));
        if(user.getPassword().equals(info.getPassword())){
            return ResponseEntity.ok("Loged in!");
        }
        return  ResponseEntity.badRequest().body("Password not correct!");

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
