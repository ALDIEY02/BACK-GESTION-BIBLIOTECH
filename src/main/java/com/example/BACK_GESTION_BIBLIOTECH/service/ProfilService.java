package com.example.BACK_GESTION_BIBLIOTECH.service;


import java.util.List;

import com.example.BACK_GESTION_BIBLIOTECH.model.Profil;

import io.micrometer.core.instrument.Meter.Id;

public interface ProfilService {
    Profil save(Profil profil);
    Profil findProfilById(Long id);
    List<Profil> findAll();

}
