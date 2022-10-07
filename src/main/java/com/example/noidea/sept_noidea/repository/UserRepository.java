package com.example.noidea.sept_noidea.repository;

import com.example.noidea.sept_noidea.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Override
    Iterable<User> findAll();
//    public Page<User> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM user WHERE uid = :uid AND DF = 0",nativeQuery = true)
    Optional<User> findBy(@Param("uid") int uid);
    @Query(value = "SELECT * FROM user WHERE username = :username AND DF = 0",nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);

}
