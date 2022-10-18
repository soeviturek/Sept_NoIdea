package com.example.noidea.sept_noidea.service;

import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.model.Appointment;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.repository.BookingRepository;
import com.example.noidea.sept_noidea.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookingServiceImplTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private BookingRepository bookingRepository;

    @MockBean
    private BookingServiceImpl bookingService;





    @Test
    void addAppointment() {
        Appointment appointment = new Appointment();
        appointment.setIdAppointment(1);
        appointment.setUID(1);
        appointment.setDoctorId(1);
        //appointment.setDateTime("2023-11-12");
        appointment.setDeleteFlag(0);
        Appointment appointment1 = bookingService.addAppointment(appointment);
        assertNotNull(appointment1);
        assertThat(appointment1.getIdAppointment()).isEqualTo(1);

    }

    @Test
    void getAppointment() {
        Appointment appointment = new Appointment();
        appointment.setIdAppointment(1);
        appointment.setUID(1);
        appointment.setDoctorId(1);
        //appointment.setDateTime("2023-11-12");
        appointment.setDeleteFlag(0);
        assertEquals(appointment,bookingService.getAppointment(1));
    }

    @Test
    void getAllAppointments() {
        //when(bookingRepository.findAll()).thenReturn(Stream.of(new Appointment(1,1,1,"2023-11-11",0)).collect(Collectors.toList()));
        assertNotNull(bookingRepository);
        assertEquals(1,bookingService.getAllAppointments().size());
    }
}