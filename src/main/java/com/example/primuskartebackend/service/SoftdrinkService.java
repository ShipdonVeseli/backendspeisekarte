package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Limonaden;
import com.example.primuskartebackend.entity.Softdrinks;
import com.example.primuskartebackend.repository.LimonadenRepository;
import com.example.primuskartebackend.repository.SoftdrinksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SoftdrinkService {

    private SoftdrinksRepository softdrinksRepository;

    @Autowired
    public SoftdrinkService(SoftdrinksRepository softdrinksRepository){
        this.softdrinksRepository = softdrinksRepository;
    }

    public Softdrinks createSoftdrink(Softdrinks softdrinks){
        return softdrinksRepository.save(softdrinks);
    }

    public void deleteSoftdrinks(Long softdrinksId){
        softdrinksRepository.deleteById(softdrinksId);
    }

    public Softdrinks updateSoftdrinks(Softdrinks softdrinks) {
        Softdrinks softdrinksOld = softdrinksRepository.findById(softdrinks.getId()).get();
        softdrinksOld.setPrice(softdrinks.getPrice());
        softdrinksOld.setName(softdrinks.getName());
        softdrinksOld.setAmount(softdrinks.getAmount());
        return softdrinksRepository.save(softdrinksOld);
    }

    public List<Softdrinks> getAllSoftdrinks() {
        return softdrinksRepository.findAll();
    }
}
