package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Kategorie;
import com.example.primuskartebackend.repository.KategorieRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class KategorieService {

    private KategorieRepository kategorieRepository;

    public KategorieService(KategorieRepository kategorieRepository){
        this.kategorieRepository = kategorieRepository;
    }

    public Kategorie createKategorie(Kategorie kategorie){
        return kategorieRepository.save(kategorie);
    }

    public void deleteKategorie(Long kategorieId){
        kategorieRepository.deleteById(kategorieId);
    }

    public Kategorie updateKategorie(Kategorie kategorie) {
        Kategorie kategorie1 = kategorieRepository.findById(kategorie.getId()).get();
        kategorie1.setLink(kategorie.getLink());
        kategorie1.setName(kategorie.getName());
        kategorie1.setPhoto(kategorie.getPhoto());
        return kategorieRepository.save(kategorie1);
    }

    public List<Kategorie> getAllKategorie() {
        return kategorieRepository.findAll();
    }
}
