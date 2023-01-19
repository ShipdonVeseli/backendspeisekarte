package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Cocktails;
import com.example.primuskartebackend.entity.Longdrinks;
import com.example.primuskartebackend.repository.LongdrinksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LongdrinksService {
    private LongdrinksRepository longdrinksRepository;

    @Autowired
    public LongdrinksService(LongdrinksRepository longdrinksRepository){
        this.longdrinksRepository = longdrinksRepository;
    }

    public Longdrinks createLongdrink(Longdrinks longdrinks){
        return longdrinksRepository.save(longdrinks);
    }

    public void deleteLongdrink(Long longdrinkId){
        longdrinksRepository.deleteById(longdrinkId);
    }

    public Longdrinks updateLongdrink(Longdrinks longdrinks) {
        Longdrinks longdrinkOld = longdrinksRepository.findById(longdrinks.getId()).get();
        longdrinkOld.setAlcohol(longdrinks.getAlcohol());
        longdrinkOld.setPrice(longdrinks.getPrice());
        longdrinkOld.setAlcoholamount(longdrinks.getAlcoholamount());
        longdrinkOld.setSoftdrinkamount(longdrinks.getSoftdrinkamount());
        longdrinkOld.setSoftdrink(longdrinks.getSoftdrink());
        return longdrinksRepository.save(longdrinkOld);
    }

    public List<Longdrinks> getAllLongdrinks() {
        return longdrinksRepository.findAll();
    }
}
