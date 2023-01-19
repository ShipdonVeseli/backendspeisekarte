package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Cocktails;
import com.example.primuskartebackend.entity.Desserts;
import com.example.primuskartebackend.service.CocktailsService;
import com.example.primuskartebackend.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/desserts")
public class DessertController {

    private DessertService dessertService;

    @Autowired
    public DessertController(DessertService dessertService){
        this.dessertService = dessertService;
    }

    @PostMapping()
    public ResponseEntity<Desserts> createDesserts(@RequestBody Desserts desserts){
        Desserts desserts1 = dessertService.createDessert(desserts);
        return new ResponseEntity<>(desserts1, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Desserts> updateDesserts(@RequestBody Desserts desserts){
        Desserts desserts1 = dessertService.updateDessert(desserts);
        return new ResponseEntity<>(desserts1, HttpStatus.OK);
    }

    @DeleteMapping("/{dessertsId}")
    public ResponseEntity<?> deleteCocktail(@PathVariable Long dessertsId){
        dessertService.deleteDessert(dessertsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Desserts>> getAllDesserts(){
        return new ResponseEntity<>(dessertService.getAllDesserts(), HttpStatus.OK);
    }

}
