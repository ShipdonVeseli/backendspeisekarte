package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Desserts;
import com.example.primuskartebackend.entity.Limonaden;
import com.example.primuskartebackend.repository.DessertRepository;
import com.example.primuskartebackend.repository.LimonadenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LimonadenService {

    private LimonadenRepository limonadenRepository;

    @Autowired
    public LimonadenService(LimonadenRepository limonadenRepository){
        this.limonadenRepository = limonadenRepository;
    }

    public Limonaden createLimonade(Limonaden limonaden){
        return limonadenRepository.save(limonaden);
    }

    public void deleteLimonaden(Long limonadenId){
        limonadenRepository.deleteById(limonadenId);
    }

    public Limonaden updateLimonaden(Limonaden limonaden) {
        Limonaden limonadenOld = limonadenRepository.findById(limonaden.getId()).get();
        limonadenOld.setPrice(limonaden.getPrice());
        limonadenOld.setName(limonaden.getName());
        limonadenOld.setAmount(limonaden.getAmount());
        return limonadenRepository.save(limonadenOld);
    }

    public List<Limonaden> getAllLimonaden() {
        return limonadenRepository.findAll();
    }
}
