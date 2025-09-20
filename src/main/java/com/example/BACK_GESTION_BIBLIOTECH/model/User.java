package com.example.BACK_GESTION_BIBLIOTECH.model;

import java.util.Collection;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;
    private String nom;
    private String adresse;
    private String email;
    private String login;
    private String password;
    private String numero;
    private String codeuser;

    @ManyToOne
    @JoinColumn(name = "profil_id") // FK vers Profil
    private Profil profil;

    //public User(String user)

    //
}

