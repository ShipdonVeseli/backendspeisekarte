package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Desserts;
import com.example.primuskartebackend.entity.Flaschen;
import com.example.primuskartebackend.repository.DessertRepository;
import com.example.primuskartebackend.repository.FlaschenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FlaschenService {

    private FlaschenRepository flaschenRepository;

    @Autowired
    public FlaschenService(FlaschenRepository flaschenRepository){
        this.flaschenRepository = flaschenRepository;
    }

    public Flaschen createFlaschen(Flaschen flaschen){
        return flaschenRepository.save(flaschen);
    }

    public void deleteFlaschen(Long flaschenId){
        flaschenRepository.deleteById(flaschenId);
    }

    public Flaschen updateFlaschen(Flaschen flaschen) {
        Flaschen flaschenOld = flaschenRepository.findById(flaschen.getId()).get();
        flaschenOld.setFlaschenname(flaschen.getFlaschenname());
        flaschenOld.setPrice(flaschen.getPrice());
        flaschenOld.setAlcoholamount(flaschen.getAlcoholamount());
        flaschenOld.setSoftdrink(flaschen.getSoftdrink());
        flaschenOld.setSoftdrinkamount(flaschen.getSoftdrinkamount());
        return flaschenRepository.save(flaschenOld);
    }

    public List<Flaschen> getAllFlaschen() {
        return flaschenRepository.findAll();
    }
}
