package com.project.clinic.repository;

import com.project.clinic.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {

//    Optional<Users> findByName(String username);
    Optional<Users> findByEmail(String email);
}
