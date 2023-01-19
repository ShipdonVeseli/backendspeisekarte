package com.example.primuskartebackend.repository;

import com.example.primuskartebackend.entity.Cocktails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailsRepository extends JpaRepository<Cocktails, Long> {

}
