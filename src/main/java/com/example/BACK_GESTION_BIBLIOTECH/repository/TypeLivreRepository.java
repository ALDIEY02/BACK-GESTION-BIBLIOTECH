package com.example.BACK_GESTION_BIBLIOTECH.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BACK_GESTION_BIBLIOTECH.model.TypeLivre;

@Repository
public interface TypeLivreRepository extends JpaRepository<TypeLivre, Long> {
    Optional<TypeLivre> findByLibelle(String libelle);
    Boolean existsByLibelle(String libelle);
}
