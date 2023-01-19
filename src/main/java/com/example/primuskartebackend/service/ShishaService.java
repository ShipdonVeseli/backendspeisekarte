package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.KaffeeTee;
import com.example.primuskartebackend.entity.Shisha;
import com.example.primuskartebackend.repository.KaffeeTeeRepository;
import com.example.primuskartebackend.repository.ShishaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ShishaService {

    private ShishaRepository shishaRepository;

    @Autowired
    public ShishaService(ShishaRepository shishaRepository){
        this.shishaRepository = shishaRepository;
    }

    public Shisha createShisha(Shisha shisha){
        return shishaRepository.save(shisha);
    }

    public void deleteShisha(Long shishaId){
        shishaRepository.deleteById(shishaId);
    }

    public Shisha updateShisha(Shisha shisha) {
        Shisha shishaOld = shishaRepository.findById(shisha.getId()).get();
        shishaOld.setPrice(shisha.getPrice());
        shishaOld.setBrand(shisha.getBrand());
        shishaOld.setName(shisha.getName());
        shishaOld.setTaste(shisha.getTaste());
        return shishaRepository.save(shishaOld);
    }

    public List<Shisha> getAllShishas() {
        return shishaRepository.findAll();
    }
}
