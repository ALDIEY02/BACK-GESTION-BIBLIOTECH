package com.example.BACK_GESTION_BIBLIOTECH.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BACK_GESTION_BIBLIOTECH.model.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {
    Page<Auteur> findByNomContainingIgnoreCaseOrPrenomContainningIgnoreCase(String nom,String prenom, org.springframework.data.domain.Pageable pageable);
}
