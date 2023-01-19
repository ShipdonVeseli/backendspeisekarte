package com.example.primuskartebackend.service;


import com.example.primuskartebackend.entity.Shots;
import com.example.primuskartebackend.entity.Softdrinks;
import com.example.primuskartebackend.repository.ShotRepository;
import com.example.primuskartebackend.repository.SoftdrinksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ShotService {

    private ShotRepository shotRepository;

    @Autowired
    public ShotService(ShotRepository shotRepository){
        this.shotRepository = shotRepository;
    }

    public Shots createShot(Shots shot){
        return shotRepository.save(shot);
    }

    public void deleteShot(Long shotId){
        shotRepository.deleteById(shotId);
    }

    public Shots updateShot(Shots shots) {
        Shots shotsOld = shotRepository.findById(shots.getId()).get();
        shotsOld.setAmount(shots.getAmount());
        shotsOld.setName(shots.getName());
        shotsOld.setPrice(shots.getPrice());
        return shotRepository.save(shotsOld);
    }

    public List<Shots> getAllShots() {
        return shotRepository.findAll();
    }
}
