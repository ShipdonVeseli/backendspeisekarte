package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Cocktails;
import com.example.primuskartebackend.repository.CocktailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CocktailsService {

    private CocktailsRepository cocktailsRepository;

    @Autowired
    public CocktailsService(CocktailsRepository cocktailsRepository){
        this.cocktailsRepository = cocktailsRepository;
    }

    public Cocktails createCocktail(Cocktails cocktails){
        return cocktailsRepository.save(cocktails);
    }

    public void deleteCocktail(Long cocktailId){
       cocktailsRepository.deleteById(cocktailId);
    }

    public Cocktails updateCocktails(Cocktails cocktails) {
        Cocktails cocktailsOld = cocktailsRepository.findById(cocktails.getId()).get();
        cocktailsOld.setName(cocktails.getName());
        cocktailsOld.setPrice(cocktails.getPrice());
        cocktailsOld.setAlcohol(cocktails.getAlcohol());
        cocktailsOld.setDescription(cocktails.getDescription());
        cocktailsOld.setPhoto(cocktails.getPhoto());
        return cocktailsRepository.save(cocktailsOld);
    }

    public List<Cocktails> getAllCocktails() {
        return cocktailsRepository.findAll();
    }
}
