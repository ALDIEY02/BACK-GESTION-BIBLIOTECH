package com.example.BACK_GESTION_BIBLIOTECH.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AuteurRequest {
    private Long id;
    private String nom;
    private String prenom;
    private String nationalite;
    private Date datenaissance;
    private String resume;
    private String email;
    private Long userId;
}
