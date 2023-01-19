package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Aktion;
import com.example.primuskartebackend.entity.Bewertung;
import com.example.primuskartebackend.service.BewertungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/bewertung")
public class BewertungController {

    private BewertungService bewertungService;

    @Autowired
    public BewertungController(BewertungService bewertungService){
        this.bewertungService = bewertungService;
    }

    @PostMapping()
    public ResponseEntity<Bewertung> createBewertung(@RequestBody Bewertung bewertung){
        Bewertung newBewertung = bewertungService.createBewertung(bewertung);
        return new ResponseEntity<>(newBewertung, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Bewertung>> getAllBewertung(){
        return new ResponseEntity<>(bewertungService.getAllBewertungen(), HttpStatus.OK);
    }
}
