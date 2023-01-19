package com.example.primuskartebackend.repository;

import com.example.primuskartebackend.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
