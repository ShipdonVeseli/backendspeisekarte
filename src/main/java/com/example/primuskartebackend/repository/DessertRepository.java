package com.example.primuskartebackend.repository;

import com.example.primuskartebackend.entity.Desserts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertRepository extends JpaRepository<Desserts, Long> {
}
