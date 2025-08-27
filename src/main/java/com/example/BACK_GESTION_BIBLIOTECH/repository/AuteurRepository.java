package com.example.BACK_GESTION_BIBLIOTECH.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BACK_GESTION_BIBLIOTECH.model.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {
    
}
