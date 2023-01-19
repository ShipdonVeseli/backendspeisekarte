package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Limonaden;
import com.example.primuskartebackend.entity.Shots;
import com.example.primuskartebackend.service.LimonadenService;
import com.example.primuskartebackend.service.ShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/limonaden")
public class LimonadenController {

    private LimonadenService limonadenService;

    @Autowired
    public LimonadenController(LimonadenService limonadenService){
        this.limonadenService = limonadenService;
    }

    @PostMapping()
    public ResponseEntity<Limonaden> createLimonaden(@RequestBody Limonaden limonaden){
        Limonaden newLimonaden= limonadenService.createLimonade(limonaden);
        return new ResponseEntity<>(newLimonaden, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Limonaden> updateLimonaden(@RequestBody Limonaden limonaden){
        Limonaden limonaden1 = limonadenService.updateLimonaden(limonaden);
        return new ResponseEntity<>(limonaden1, HttpStatus.OK);
    }

    @DeleteMapping("/{limonadenId}")
    public ResponseEntity<?> deleteLimonaden(@PathVariable Long limonadenId){
        limonadenService.deleteLimonaden(limonadenId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Limonaden>> getAllLimonaden(){
        return new ResponseEntity<>(limonadenService.getAllLimonaden(), HttpStatus.OK);
    }
}
