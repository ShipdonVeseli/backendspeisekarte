package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Cocktails;
import com.example.primuskartebackend.entity.Desserts;
import com.example.primuskartebackend.repository.CocktailsRepository;
import com.example.primuskartebackend.repository.DessertRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DessertService {
    private DessertRepository dessertRepository;

    @Autowired
    public DessertService(DessertRepository dessertRepository){
        this.dessertRepository = dessertRepository;
    }

    public Desserts createDessert(Desserts desserts){
        return dessertRepository.save(desserts);
    }

    public void deleteDessert(Long dessertId){
        dessertRepository.deleteById(dessertId);
    }

    public Desserts updateDessert(Desserts desserts) {
        Desserts dessertOld = dessertRepository.findById(desserts.getId()).get();
        dessertOld.setName(desserts.getName());
        dessertOld.setPrice(desserts.getPrice());
        dessertOld.setPhoto(desserts.getPhoto());
        return dessertRepository.save(dessertOld);
    }

    public List<Desserts> getAllDesserts() {
        return dessertRepository.findAll();
    }
}
