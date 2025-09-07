package com.example.BACK_GESTION_BIBLIOTECH.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BACK_GESTION_BIBLIOTECH.model.Profil;
import com.example.BACK_GESTION_BIBLIOTECH.repository.ProfilRepository;

@Service
public class ProfilServiceImpl implements ProfilService {

    private final ProfilRepository profilRepository;

    public ProfilServiceImpl(ProfilRepository profilRepository){

        this.profilRepository=profilRepository;

    }

    @Override
    public Profil save(Profil profil) {
        return profilRepository.save(profil);
    }

    @Override
    public List<Profil> findAll() {
        return null;
        
    }

    @Override
    public Profil findProfilById(Long id) {
        return profilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profil non trouvé"));
    }
}
