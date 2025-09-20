package com.example.BACK_GESTION_BIBLIOTECH.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BACK_GESTION_BIBLIOTECH.model.TypeLivre;
import com.example.BACK_GESTION_BIBLIOTECH.repository.TypeLivreRepository;

@Transactional
@Service
public class TypeLivreService {

    @Autowired
    private final TypeLivreRepository typeLivreRepository;

    public TypeLivreService(TypeLivreRepository typeLivreRepository) {
        this.typeLivreRepository = typeLivreRepository;
    }

    public List<TypeLivre> getAllTypeLivres() {
        return typeLivreRepository.findAll();
    }

    public TypeLivre getTypeLivreById(Long id) {
        return typeLivreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeLivre inexistant"));
    }

    public TypeLivre getTypeLivreByLibelle(String libelle) {
        return typeLivreRepository.findByLibelle(libelle)
                .orElseThrow(() -> new RuntimeException("TypeLivre avec le libellé '" + libelle + "' non trouvé"));
    }

    public TypeLivre saveTypeLivre(TypeLivre typeLivre) {
        if (typeLivreRepository.existsByLibelle(typeLivre.getLibelle())) {
            throw new RuntimeException("Le libellé '" + typeLivre.getLibelle() + "' est déjà utilisé.");
        }
        return typeLivreRepository.save(typeLivre);
    }

    public TypeLivre updateTypeLivre(Long id, TypeLivre typeLivreDetails) {
        TypeLivre typeLivre = typeLivreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeLivre inexistant avec l'id: " + id));

        if (!typeLivre.getLibelle().equals(typeLivreDetails.getLibelle()) &&
                typeLivreRepository.existsByLibelle(typeLivreDetails.getLibelle())) {
            throw new RuntimeException("Le libellé '" + typeLivreDetails.getLibelle() + "' est déjà utilisé.");
        }

        typeLivre.setLibelle(typeLivreDetails.getLibelle());

        return typeLivreRepository.save(typeLivre);
    }

    public void deleteTypeLivre(Long id) {
        typeLivreRepository.deleteById(id);
    }
}
