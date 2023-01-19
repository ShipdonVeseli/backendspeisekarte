package com.example.primuskartebackend.controller;


import com.example.primuskartebackend.entity.Aktion;
import com.example.primuskartebackend.entity.Longdrinks;
import com.example.primuskartebackend.service.AktionService;
import com.example.primuskartebackend.service.LongdrinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/aktion")
public class AktionController {

    private AktionService aktionService;

    @Autowired
    public AktionController(AktionService aktionService){
        this.aktionService = aktionService;
    }

    @PostMapping()
    public ResponseEntity<Aktion> createAktion(@RequestBody Aktion aktion){
        Aktion newAktion= aktionService.createAktion(aktion);
        return new ResponseEntity<>(newAktion, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Aktion> updateAktion(@RequestBody Aktion aktion){
        Aktion newaktion = aktionService.updateAktion(aktion);
        return new ResponseEntity<>(newaktion, HttpStatus.OK);
    }

    @DeleteMapping("/{aktionId}")
    public ResponseEntity<?> deleteLongdrink(@PathVariable Long aktionId){
        aktionService.deleteAktion(aktionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Aktion>> getAllAktion(){
        return new ResponseEntity<>(aktionService.getAllAktion(), HttpStatus.OK);
    }
}
