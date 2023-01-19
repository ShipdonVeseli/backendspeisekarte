package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Cocktails;
import com.example.primuskartebackend.entity.Food;
import com.example.primuskartebackend.service.CocktailsService;
import com.example.primuskartebackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/food")
public class FoodController {

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    @PostMapping()
    public ResponseEntity<Food> createFood(@RequestBody Food food){
        Food food1 = foodService.createFood(food);
        return new ResponseEntity<>(food1, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Food> updateFood(@RequestBody Food food){
        Food food1 = foodService.updateFood(food);
        return new ResponseEntity<>(food1, HttpStatus.OK);
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<?> deleteCocktail(@PathVariable Long foodId){
        foodService.deleteFood(foodId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Food>> getAllCocktails(){
        return new ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);
    }

}
