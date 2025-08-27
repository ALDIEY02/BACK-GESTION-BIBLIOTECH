package com.example.BACK_GESTION_BIBLIOTECH.dto;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String prenom;
    private String nom;
    private String adresse;
    private String email;
    private String login;
    private String password;
    private String codeuser;
}
