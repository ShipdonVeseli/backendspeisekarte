package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Longdrinks;
import com.example.primuskartebackend.service.LongdrinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/longdrinks")
public class LongdrinksController {

    private LongdrinksService longdrinksService;

    @Autowired
    public LongdrinksController(LongdrinksService longdrinksService){
        this.longdrinksService = longdrinksService;
    }

    @PostMapping()
    public ResponseEntity<Longdrinks> createLongdrink(@RequestBody Longdrinks longdrinks){
        Longdrinks newLongdrink= longdrinksService.createLongdrink(longdrinks);
        return new ResponseEntity<>(newLongdrink, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Longdrinks> updateLongdrink(@RequestBody Longdrinks longdrinks){
        Longdrinks cocktails1 = longdrinksService.updateLongdrink(longdrinks);
        return new ResponseEntity<>(cocktails1, HttpStatus.OK);
    }

    @DeleteMapping("/{longdrinkId}")
    public ResponseEntity<?> deleteLongdrink(@PathVariable Long longdrinkId){
        longdrinksService.deleteLongdrink(longdrinkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Longdrinks>> getAllLongdrinks(){
        return new ResponseEntity<>(longdrinksService.getAllLongdrinks(), HttpStatus.OK);
    }
}
