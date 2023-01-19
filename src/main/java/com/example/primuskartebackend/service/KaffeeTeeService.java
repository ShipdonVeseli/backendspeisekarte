package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.KaffeeTee;
import com.example.primuskartebackend.repository.KaffeeTeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class KaffeeTeeService {

    private KaffeeTeeRepository kaffeeTeeRepository;

    @Autowired
    public KaffeeTeeService(KaffeeTeeRepository kaffeeTeeRepository){
        this.kaffeeTeeRepository = kaffeeTeeRepository;
    }

    public KaffeeTee createKaffeeTee(KaffeeTee kaffeeTee){
        return kaffeeTeeRepository.save(kaffeeTee);
    }

    public void deleteKaffeeTee(Long KaffeeTeeId){
        kaffeeTeeRepository.deleteById(KaffeeTeeId);
    }

    public KaffeeTee updateKaffeeTee(KaffeeTee kaffeeTee) {
        KaffeeTee kaffeeTeeOld = kaffeeTeeRepository.findById(kaffeeTee.getId()).get();
        kaffeeTeeOld.setPrice(kaffeeTee.getPrice());
        kaffeeTeeOld.setName(kaffeeTee.getName());
        return kaffeeTeeRepository.save(kaffeeTeeOld);
    }

    public List<KaffeeTee> getAllKaffeeTee() {
        return kaffeeTeeRepository.findAll();
    }
}
