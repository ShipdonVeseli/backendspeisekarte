package com.example.primuskartebackend.repository;

import com.example.primuskartebackend.entity.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategorieRepository extends JpaRepository<Kategorie, Long> {
}
