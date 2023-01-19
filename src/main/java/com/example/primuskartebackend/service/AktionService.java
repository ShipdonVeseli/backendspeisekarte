package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Aktion;
import com.example.primuskartebackend.repository.AktionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AktionService {

    private AktionRepository aktionRepository;

    @Autowired
    public AktionService(AktionRepository aktionRepository){
        this.aktionRepository = aktionRepository;
    }

    public Aktion createAktion(Aktion aktion){
        return aktionRepository.save(aktion);
    }

    public void deleteAktion(Long aktionId){
        aktionRepository.deleteById(aktionId);
    }

    public Aktion updateAktion(Aktion aktion) {
        Aktion aktionOld = aktionRepository.findById(aktion.getId()).get();
        aktionOld.setPrice(aktion.getPrice());
        aktionOld.setBeigetrank(aktion.getBeigetrank());
        aktionOld.setFlascheamount(aktion.getFlascheamount());
        aktionOld.setShishaamount(aktion.getShishaamount());
        aktionOld.setFlaschename(aktion.getFlaschename());
        return aktionRepository.save(aktionOld);
    }

    public List<Aktion> getAllAktion() {
        return aktionRepository.findAll();
    }
}
