package com.example.noidea.sept_noidea.service;

import com.example.noidea.sept_noidea.model.Appointment;
import com.example.noidea.sept_noidea.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

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
        Optional<Appointment> appOpts = bookingRepository.findById(id);
        if(appOpts.isEmpty()){
            return null;
        }
        return appOpts.get();
    }
    @Override
    public List<Appointment> getAppointmentByUid(int uid) {
        List<Appointment> apps = bookingRepository.getByUid(uid);

        return apps;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appList = (List<Appointment>)bookingRepository.findAll();
        return appList;



    }

    @Override
    public List<Appointment> getAllAppointmentsByUid(int id) {
//        return bookingRepository.getAllById(id);
        return null;
    }
}
