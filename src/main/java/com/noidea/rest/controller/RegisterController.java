package com.noidea.rest.controller;

import com.noidea.rest.dao.UserDao;
import com.noidea.rest.model.LoginInfo;
import com.noidea.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class RegisterController {
    @Autowired
    private UserDao userDao;
    //get all users api
    @GetMapping("/all_users")
    public ResponseEntity<Object> getAllUsers() {
        List<User> userList = userDao.getAllUser();
        return ResponseEntity.ok().header("OK!").body(userList);
    }
    //create
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        userDao.addUser(user);
        return ResponseEntity.ok("Created!");
    }
    //get by username
    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Object> getUserbyId(@PathVariable("id") String id){
        User user = userDao.getUser(id);
        return ResponseEntity.ok().body(user);
    }
    //update
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateUser(@PathVariable(name = "id") String id, @RequestBody User updateUser){
        User user = userDao.getUser(id);
        user.setEmail(updateUser.getEmail());
        user.setMobile(updateUser.getMobile());
        user.setPassword(updateUser.getPassword());
        int updatedEmployee = userDao.addUser(user);
        return ResponseEntity.ok("Updated!");
    }
    //login
    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity<Object> login(@RequestBody LoginInfo info){
        User user = userDao.getUser(info.getuserid());
        if(user.getPassword().equals(info.getPassword())){
            return ResponseEntity.ok("Loged in!");
        }
        return  ResponseEntity.badRequest().body("Password not correct!");

    }
    //delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteUser(@PathVariable String id){
        User user= userDao.getUser(id);
        user.setDeleteFlag("1");
        int updatedEmployee = userDao.addUser(user);
        return ResponseEntity.ok("Deleted");
    }

}
