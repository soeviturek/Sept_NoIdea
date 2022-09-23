package com.example.noidea.sept_noidea.service;

import com.example.noidea.sept_noidea.model.Appointment;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements  BookingService{
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return bookingRepository.save(appointment); //should return Appointment
    }

    @Override
    public Appointment getAppointment(int id) {
        Optional<Appointment> appOpt = bookingRepository.findById(id);
        if (appOpt.isEmpty()) {
            throw new ResourceNotFoundException("appointment not found");
        }
        return appOpt.get();
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appList = (List<Appointment>)bookingRepository.findAll();
        return appList;

    }
}
