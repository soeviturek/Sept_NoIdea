package com.noidea.rest.dao;


import com.noidea.rest.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public Page<User> findAll(Pageable pageable);

}
