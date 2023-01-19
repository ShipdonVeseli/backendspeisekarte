package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Softdrinks;
import com.example.primuskartebackend.entity.WeinBier;
import com.example.primuskartebackend.repository.SoftdrinksRepository;
import com.example.primuskartebackend.repository.WeinBierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class WeinBierService {


    private WeinBierRepository weinBierRepository;

    @Autowired
    public WeinBierService(WeinBierRepository weinBierRepository){
        this.weinBierRepository = weinBierRepository;
    }

    public WeinBier createWeinBier(WeinBier weinBier){
        return weinBierRepository.save(weinBier);
    }

    public void deleteWeinBier(Long weinBierId){
        weinBierRepository.deleteById(weinBierId);
    }

    public WeinBier updateWeinBier(WeinBier weinBier) {
        WeinBier weinBierOld = weinBierRepository.findById(weinBier.getId()).get();
        weinBierOld.setAmount(weinBier.getAmount());
        weinBierOld.setName(weinBier.getName());
        weinBierOld.setPrice(weinBier.getPrice());
        return weinBierRepository.save(weinBierOld);
    }

    public List<WeinBier> getAllWeinBier() {
        return weinBierRepository.findAll();
    }
}
