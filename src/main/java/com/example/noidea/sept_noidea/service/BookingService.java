package com.example.noidea.sept_noidea.service;

import com.example.noidea.sept_noidea.model.Appointment;

import java.util.List;

public interface BookingService {
    Appointment addAppointment(Appointment appointment);
    Appointment getAppointment(int id);
    List<Appointment> getAllAppointments();

    //later should add get all appointments based on userid and time range
}
