package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Shots;
import com.example.primuskartebackend.service.ShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/shot")
public class ShotController {

    private ShotService shotService;

    @Autowired
    public ShotController(ShotService shotService){
        this.shotService = shotService;
    }

    @PostMapping()
    public ResponseEntity<Shots> createShot(@RequestBody Shots shots){
        Shots newShot= shotService.createShot(shots);
        return new ResponseEntity<>(newShot, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Shots> updateShot(@RequestBody Shots shots){
        Shots shots1 = shotService.updateShot(shots);
        return new ResponseEntity<>(shots1, HttpStatus.OK);
    }

    @DeleteMapping("/{shotId}")
    public ResponseEntity<?> deleteShot(@PathVariable Long shotId){
        shotService.deleteShot(shotId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Shots>> getAllShots(){
        return new ResponseEntity<>(shotService.getAllShots(), HttpStatus.OK);
    }
}
