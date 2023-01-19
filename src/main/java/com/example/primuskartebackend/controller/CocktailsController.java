package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Cocktails;
import com.example.primuskartebackend.service.CocktailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cocktails")
public class CocktailsController {

    private CocktailsService cocktailsService;

    @Autowired
    public CocktailsController(CocktailsService cocktailsService){
        this.cocktailsService = cocktailsService;
    }

    @PostMapping()
    public ResponseEntity<Cocktails> createCocktail(@RequestBody Cocktails cocktails){
        Cocktails cocktails1 = cocktailsService.createCocktail(cocktails);
        return new ResponseEntity<>(cocktails1, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Cocktails> updateCocktail(@RequestBody Cocktails cocktails){
        Cocktails cocktails1 = cocktailsService.updateCocktails(cocktails);
        return new ResponseEntity<>(cocktails1, HttpStatus.OK);
    }

    @DeleteMapping("/{cocktailId}")
    public ResponseEntity<?> deleteCocktail(@PathVariable Long cocktailId){
        cocktailsService.deleteCocktail(cocktailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Cocktails>> getAllCocktails(){
        return new ResponseEntity<>(cocktailsService.getAllCocktails(), HttpStatus.OK);
    }
}
