package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Flaschen;
import com.example.primuskartebackend.entity.Limonaden;
import com.example.primuskartebackend.service.FlaschenService;
import com.example.primuskartebackend.service.LimonadenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/flaschen")
public class FlaschenController {

    private FlaschenService flaschenService;

    @Autowired
    public FlaschenController(FlaschenService flaschenService){
        this.flaschenService = flaschenService;
    }

    @PostMapping()
    public ResponseEntity<Flaschen> createFlaschen(@RequestBody Flaschen flaschen){
        Flaschen newFlaschen= flaschenService.createFlaschen(flaschen);
        return new ResponseEntity<>(newFlaschen, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Flaschen> updateFlaschen(@RequestBody Flaschen flaschen){
        Flaschen flaschen1 = flaschenService.updateFlaschen(flaschen);
        return new ResponseEntity<>(flaschen1, HttpStatus.OK);
    }

    @DeleteMapping("/{flaschenId}")
    public ResponseEntity<?> deleteLimonaden(@PathVariable Long flaschenId){
        flaschenService.deleteFlaschen(flaschenId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Flaschen>> getAllFlaschen(){
        return new ResponseEntity<>(flaschenService.getAllFlaschen(), HttpStatus.OK);
    }
}
