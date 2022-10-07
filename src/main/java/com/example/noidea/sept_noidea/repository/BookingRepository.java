package com.example.noidea.sept_noidea.repository;

import com.example.noidea.sept_noidea.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "select * from appointment where uid = :uid",nativeQuery = true)
    List<Appointment> getByUid(@Param("uid") int uid);
}
