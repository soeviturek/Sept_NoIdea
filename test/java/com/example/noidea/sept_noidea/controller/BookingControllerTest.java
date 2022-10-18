package com.example.noidea.sept_noidea.controller;

import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.model.Appointment;
import com.example.noidea.sept_noidea.repository.BookingRepository;
import com.example.noidea.sept_noidea.service.BookingServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;

import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RegisterController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class BookingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingServiceImpl bookingService;
    private BookingRepository bookingRepository;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void getAllAppointments() {
        List<Appointment> appList = bookingService.getAllAppointments();
        Appointment book = new Appointment();

        try {
            mockMvc.perform(get("/api/booking/all_bookings").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.idAppointment").exists())
                    .andExpect(jsonPath("$.doctorid").exists())
                    .andExpect(jsonPath("$.UID").exists())

                    .andDo(print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        verify(bookingService).addAppointment(book);
    }

    @Test
    void createAppointment() {
        Appointment appointment = new Appointment();
        appointment.setIdAppointment(1);
        appointment.setUID(1);
        appointment.setDoctorId(1);
        //appointment.setDateTime();
        appointment.setDeleteFlag(0);
        given(bookingService.addAppointment(Mockito.any())).willReturn(bookingService.addAppointment(appointment));
        try {
            mockMvc.perform(post("/api/booking/create").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.idAppointment",is(1)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        verify(bookingService, VerificationModeFactory.times(1));
        reset(bookingService);
    }

    @Test
    void getAppointmentById() {
    }

    @Test
    void updateAppointment() {
    }

    @Test
    void deleteAppointment() {
        Appointment appointment = new Appointment();
        appointment.setIdAppointment(1);
        appointment.setUID(1);
        appointment.setDoctorId(1);
        //appointment.setDateTime();
        appointment.setDeleteFlag(0);
        Appointment appointment1= bookingService.getAppointment(1);

        appointment1.setDeleteFlag(1);
        try {
            this.mockMvc.perform(delete("/booking/delete/{id}", 1))
                    .andExpect(status().isNoContent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}