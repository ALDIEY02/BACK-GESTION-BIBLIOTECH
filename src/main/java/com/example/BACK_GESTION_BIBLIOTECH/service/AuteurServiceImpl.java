package com.example.BACK_GESTION_BIBLIOTECH.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BACK_GESTION_BIBLIOTECH.model.Auteur;
import com.example.BACK_GESTION_BIBLIOTECH.repository.AuteurRepository;


@Service
public class AuteurServiceImpl implements AuteurService{
    private final AuteurRepository auteurRepository;

    public AuteurServiceImpl(AuteurRepository auteurRepository){
        this.auteurRepository = auteurRepository;
    }

    @Override
    public Auteur save(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    @Override
    public List<Auteur> findAll() {
        return auteurRepository.findAll();
    }

    

}
