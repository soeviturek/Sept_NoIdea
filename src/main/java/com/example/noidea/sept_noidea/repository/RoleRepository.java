package com.example.noidea.sept_noidea.repository;

import com.example.noidea.sept_noidea.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "SELECT * FROM user WHERE username = :name",nativeQuery = true)
    Optional<Role> findByname(@Param("name") String name);
}
