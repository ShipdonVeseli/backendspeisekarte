package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Shisha;
import com.example.primuskartebackend.entity.Softdrinks;
import com.example.primuskartebackend.service.ShishaService;
import com.example.primuskartebackend.service.SoftdrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/softdrinks")
public class SoftdrinkController {


    private SoftdrinkService softdrinkService;

    @Autowired
    public SoftdrinkController(SoftdrinkService softdrinkService){
        this.softdrinkService = softdrinkService;
    }

    @PostMapping()
    public ResponseEntity<Softdrinks> createSoftdrink(@RequestBody Softdrinks softdrinks){
        Softdrinks softdrinks1 = softdrinkService.createSoftdrink(softdrinks);
        return new ResponseEntity<>(softdrinks1, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Softdrinks> updateSoftdrink(@RequestBody Softdrinks softdrinks){
        Softdrinks softdrinks1 = softdrinkService.updateSoftdrinks(softdrinks);
        return new ResponseEntity<>(softdrinks1, HttpStatus.OK);
    }

    @DeleteMapping("/{softdrinkId}")
    public ResponseEntity<?> deleteSoftdrink(@PathVariable Long softdrinkId){
        softdrinkService.deleteSoftdrinks(softdrinkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Softdrinks>> getAllSoftdrinks(){
        return new ResponseEntity<>(softdrinkService.getAllSoftdrinks(), HttpStatus.OK);
    }

}
