package com.noidea.rest.dao;
import com.noidea.rest.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    private static List<User> userList = new ArrayList<>();

    public int addUser(User user){
        userList.add(user);
        return 0;
    }
    public User getUser(String id){
        for(User u : userList){
            if(u.getUserid().equals(id)){
                return u;
            }
        }
        return null;
    }
    public List<User> getAllUser(){
        return userList;
    }
}