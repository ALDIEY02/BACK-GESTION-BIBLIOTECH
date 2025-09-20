package com.example.BACK_GESTION_BIBLIOTECH.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BACK_GESTION_BIBLIOTECH.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(String nom, String prenom, Pageable pageable);
    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);
    Boolean existsByLogin(String login); 
    Boolean existsByEmail(String email);    
}

