package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Shots;
import com.example.primuskartebackend.entity.WeinBier;
import com.example.primuskartebackend.service.ShotService;
import com.example.primuskartebackend.service.WeinBierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/weinbier")
public class WeinBierController {

    private WeinBierService weinBierService;

    @Autowired
    public WeinBierController(WeinBierService weinBierService){
        this.weinBierService = weinBierService;
    }

    @PostMapping()
    public ResponseEntity<WeinBier> createWein(@RequestBody WeinBier weinBier){
        WeinBier newWeinBier= weinBierService.createWeinBier(weinBier);
        return new ResponseEntity<>(newWeinBier, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<WeinBier> updateWeinBier(@RequestBody WeinBier weinBier){
        WeinBier weinBier1 = weinBierService.updateWeinBier(weinBier);
        return new ResponseEntity<>(weinBier1, HttpStatus.OK);
    }

    @DeleteMapping("/{weinbierId}")
    public ResponseEntity<?> deleteShot(@PathVariable Long weinbierId){
        weinBierService.deleteWeinBier(weinbierId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<WeinBier>> getAllWeinBier(){
        return new ResponseEntity<>(weinBierService.getAllWeinBier(), HttpStatus.OK);
    }

}
