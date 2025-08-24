package com.example.BACK_GESTION_BIBLIOTECH.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String nationalite;
    private Date datenaissance;
    private String resume;
    private String email;
}
