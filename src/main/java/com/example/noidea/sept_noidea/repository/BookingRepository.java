package com.example.noidea.sept_noidea.repository;

import com.example.noidea.sept_noidea.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Appointment, Integer> {
}
