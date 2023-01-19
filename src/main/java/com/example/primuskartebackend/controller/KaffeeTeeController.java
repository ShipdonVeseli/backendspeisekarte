package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Food;
import com.example.primuskartebackend.entity.KaffeeTee;
import com.example.primuskartebackend.service.FoodService;
import com.example.primuskartebackend.service.KaffeeTeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/kaffeetee")
public class KaffeeTeeController {

    private KaffeeTeeService kaffeeTeeService;

    @Autowired
    public KaffeeTeeController(KaffeeTeeService kaffeeTeeService){
        this.kaffeeTeeService = kaffeeTeeService;
    }

    @PostMapping()
    public ResponseEntity<KaffeeTee> createKaffee(@RequestBody KaffeeTee kaffeeTee){
        KaffeeTee kaffeeTee1 = kaffeeTeeService.createKaffeeTee(kaffeeTee);
        return new ResponseEntity<>(kaffeeTee1, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<KaffeeTee> updateKaffee(@RequestBody KaffeeTee kaffeeTee){
        KaffeeTee kaffeeTee1 = kaffeeTeeService.updateKaffeeTee(kaffeeTee);
        return new ResponseEntity<>(kaffeeTee1, HttpStatus.OK);
    }

    @DeleteMapping("/{kaffeeId}")
    public ResponseEntity<?> deleteKaffee(@PathVariable Long kaffeeId){
        kaffeeTeeService.deleteKaffeeTee(kaffeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<KaffeeTee>> getAllKaffee(){
        return new ResponseEntity<>(kaffeeTeeService.getAllKaffeeTee(), HttpStatus.OK);
    }

}
