package com.example.BACK_GESTION_BIBLIOTECH.service;

import java.util.List;

import com.example.BACK_GESTION_BIBLIOTECH.model.Auteur;

public interface AuteurService {
    Auteur save(Auteur auteur);
    List<Auteur> findAll();
}
