package com.noidea.rest.controller;

import com.noidea.rest.dao.AvailabilityDao;
import com.noidea.rest.model.Availability;
import com.noidea.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/av")
public class AvailabilityController{
    @Autowired
    private AvailabilityDao availabilityDao;

    //doctor add booking
    @PostMapping("/addav")
    boolean addAvailability(@RequestBody String doctorId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime){
        //check if the user is a doctor
//        Optional<User> user = availabilityDao.get
        //if yes, add the availability to database
        return false;
    }

    //doctor add booking
    @GetMapping("/getav")
    boolean getAvailability(@RequestBody String doctorId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime){
        //check if the user is a doctor

        //if yes, get the availability

        //if there is no availability return false
        return false;
    }

    //doctor add booking
    @DeleteMapping("/deleteav")
    boolean deleteAvailability(@RequestBody String doctorId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime){
        //check if the user is a doctor

        //if yes, get the availability, set deleteFlag to 1, update to database
        //if there is no availability return false
        return false;
    }
    @GetMapping("/updateav")
    boolean updateAvailability(@RequestBody String id, Availability updateAvailability){
        //get Availability by id
        //update using updateAvailability
        //add back to database
        return false;
    }
}
