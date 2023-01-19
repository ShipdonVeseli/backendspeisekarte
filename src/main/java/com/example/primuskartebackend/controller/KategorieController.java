package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.KaffeeTee;
import com.example.primuskartebackend.entity.Kategorie;
import com.example.primuskartebackend.service.KaffeeTeeService;
import com.example.primuskartebackend.service.KategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/kategorie")
public class KategorieController {

    private KategorieService kategorieService;

    @Autowired
    public KategorieController(KategorieService kategorieService){
        this.kategorieService = kategorieService;
    }

    @PostMapping()
    public ResponseEntity<Kategorie> createKategorie(@RequestBody Kategorie kategorie){
        Kategorie kategorie1 = kategorieService.createKategorie(kategorie);
        return new ResponseEntity<>(kategorie1, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Kategorie> updateKategorie(@RequestBody Kategorie kategorie){
        Kategorie kategorie1 = kategorieService.updateKategorie(kategorie);
        return new ResponseEntity<>(kategorie1, HttpStatus.OK);
    }

    @DeleteMapping("/{kategorieId}")
    public ResponseEntity<?> deleteKategorie(@PathVariable Long kategorieId){
        kategorieService.deleteKategorie(kategorieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Kategorie>> getAllKategorie(){
        return new ResponseEntity<>(kategorieService.getAllKategorie(), HttpStatus.OK);
    }
}
