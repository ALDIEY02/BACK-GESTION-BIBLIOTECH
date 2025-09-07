package com.example.BACK_GESTION_BIBLIOTECH.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BACK_GESTION_BIBLIOTECH.model.Profil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
    Optional<Profil> findByRole(String role); // Le champ dans ton entité Profil
}
