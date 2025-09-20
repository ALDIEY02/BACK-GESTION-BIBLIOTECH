package com.example.BACK_GESTION_BIBLIOTECH.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne
    private User createdBy;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Livre> livres = new ArrayList<>();
}
