package com.example.BACK_GESTION_BIBLIOTECH.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BACK_GESTION_BIBLIOTECH.model.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    Optional<Livre> findByIsbn(String isbn);
    Optional<Livre> findByTitre(String titre);
    Boolean existsByIsbn(String isbn);
    Boolean existsByTitre(String titre);

    List<Livre> findByAuteur (Long idAuteur);
    List<Livre> findByTypeLivre (Long idTypeLivre);
    org.springframework.data.domain.Page<Livre> findByTitreContainingIgnoreCase(String titre, org.springframework.data.domain.Pageable pageable);
}
