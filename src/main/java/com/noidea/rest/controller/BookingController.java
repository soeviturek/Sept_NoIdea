package com.noidea.rest.controller;

import com.noidea.rest.dao.AppointmentDao;
import com.noidea.rest.dao.AvailabilityDao;
import com.noidea.rest.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private AppointmentDao appointmentDao;
    //doctor add booking
    @PostMapping("/addBooking")
    boolean bookAppointment(@RequestBody String patientId, String doctorId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dateTime){
        //check if patientId and doctor Id are correct
        //add to database
        return false;
    }
    //cancel booking
    @GetMapping("/cancelBooking")
    boolean cancelBooking(@RequestBody String id, String bookingId){
        //get the booking by id
        //check if the id matches with patient or doctor
        //if yes cancel the booking by setting deleteFlag to 0
        //update this to the database
        return false;
    }
    //delete booking
}
