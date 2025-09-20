package com.example.BACK_GESTION_BIBLIOTECH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Optional<Auteur> getAuteurById(Long id) {
        return auteurRepository.findById(id);
    }

    public Page<Auteur> searchAuteursByName(String name, Pageable pageable) {
        return auteurRepository.findByNomContainingIgnoreCaseOrPrenomContainningIgnoreCase(name, name, pageable);
    }

    public Auteur updateAuteur(Long id, Auteur auteurDetails) {
        Auteur auteur = auteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auteur non trouvé avec l'id: " + id));

        auteur.setNom(auteurDetails.getNom());
        auteur.setPrenom(auteurDetails.getPrenom());
        auteur.setDatenaissance(auteurDetails.getDatenaissance());
        auteur.setNationalite(auteurDetails.getNationalite());
        auteur.setResume(auteurDetails.getResume());

        return auteurRepository.save(auteur);
    }

    public void deleteAuteur(Long id) {
        auteurRepository.deleteById(id);
    }
}
