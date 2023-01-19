package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Bewertung;
import com.example.primuskartebackend.repository.BewertungRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class BewertungService {

    private BewertungRepository bewertungRepository;

    @Autowired
    public BewertungService(BewertungRepository bewertungRepository){
        this.bewertungRepository = bewertungRepository;
    }

    public Bewertung createBewertung(Bewertung bewertung){
        bewertung.setDatum(LocalDate.now().toString() +" " +LocalTime.now());
        return bewertungRepository.save(bewertung);
    }

    public List<Bewertung> getAllBewertungen() {
        return bewertungRepository.findAll();
    }
}
