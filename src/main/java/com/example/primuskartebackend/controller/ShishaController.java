package com.example.primuskartebackend.controller;


import com.example.primuskartebackend.entity.Food;
import com.example.primuskartebackend.entity.Shisha;
import com.example.primuskartebackend.service.FoodService;
import com.example.primuskartebackend.service.ShishaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/shisha")
public class ShishaController {

    private ShishaService shishaService;

    @Autowired
    public ShishaController(ShishaService shishaService){
        this.shishaService = shishaService;
    }

    @PostMapping()
    public ResponseEntity<Shisha> createShisha(@RequestBody Shisha shisha){
        Shisha shisha1 = shishaService.createShisha(shisha);
        return new ResponseEntity<>(shisha1, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Shisha> updateShisha(@RequestBody Shisha shisha){
        Shisha shisha1 = shishaService.updateShisha(shisha);
        return new ResponseEntity<>(shisha1, HttpStatus.OK);
    }

    @DeleteMapping("/{shishaId}")
    public ResponseEntity<?> deleteShisha(@PathVariable Long shishaId){
        shishaService.deleteShisha(shishaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Shisha>> getAllFood(){
        return new ResponseEntity<>(shishaService.getAllShishas(), HttpStatus.OK);
    }
}
