package com.example.BACK_GESTION_BIBLIOTECH.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Date datepublication;
    private boolean disponible;
    private String genre;
    private int stock; 
}
