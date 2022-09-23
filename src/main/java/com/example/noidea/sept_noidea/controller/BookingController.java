package com.example.noidea.sept_noidea.controller;


import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.model.Appointment;
import com.example.noidea.sept_noidea.model.LoginInfo;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.service.BookingServiceImpl;
import com.example.noidea.sept_noidea.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookingController {
    @Autowired
    private BookingServiceImpl bookingService;
    //get all users api
    @GetMapping("/all_bookings")
    public ResponseEntity<Object> getAllAppointments() {
        List<Appointment> appList = bookingService.getAllAppointments();
        return ResponseEntity.ok().header("OK!").body(appList);
    }
    //create
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody Appointment appointment){
        Appointment appDetail = bookingService.addAppointment(appointment);
        return ResponseEntity.ok().header("Created!").body(appDetail);
    }
    //get by appointment id
    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Object> getUserbyId(@PathVariable("id") int id){
        Appointment appointment = bookingService.getAppointment(id);
        return ResponseEntity.ok().body(appointment);
    }
    //update
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateUser(@PathVariable(name = "id") int id, @RequestBody Appointment updateAppointment){
        Appointment original = bookingService.getAppointment(id);
        original.setDateTime(updateAppointment.getDateTime());
        original.setDoctorId(updateAppointment.getDoctorId());
        original.setAppointmentCol(updateAppointment.getAppointmentCol());
        Appointment appDetail = bookingService.addAppointment(original);
        return ResponseEntity.ok("Updated!");
    }
    //delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteUser(@PathVariable int id){
        Appointment app = bookingService.getAppointment(id);
        app.setDeleteFlag(1);
        bookingService.addAppointment(app);
        return ResponseEntity.ok("Deleted");
    }
}
