package com.example.primuskartebackend.repository;

import com.example.primuskartebackend.entity.Shots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShotRepository extends JpaRepository<Shots, Long> {
}
