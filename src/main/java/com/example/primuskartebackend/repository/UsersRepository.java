package com.example.primuskartebackend.repository;

import com.example.primuskartebackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users getUsersByUsername(String username);
}
