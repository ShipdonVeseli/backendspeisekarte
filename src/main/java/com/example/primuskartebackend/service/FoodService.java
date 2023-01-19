package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Food;
import com.example.primuskartebackend.repository.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FoodService {


    private FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    public Food createFood(Food food){
        return foodRepository.save(food);
    }

    public void deleteFood(Long foodId){
        foodRepository.deleteById(foodId);
    }

    public Food updateFood(Food food) {
        Food foodOld = foodRepository.findById(food.getId()).get();
        foodOld.setDescription(food.getDescription());
        foodOld.setPrice(food.getPrice());
        foodOld.setName(food.getName());
        foodOld.setPhoto(food.getPhoto());
        return foodRepository.save(foodOld);
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
}
