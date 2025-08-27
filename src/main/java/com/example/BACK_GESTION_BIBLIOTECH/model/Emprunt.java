package com.example.BACK_GESTION_BIBLIOTECH.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date debutemprunt;
    private Date finemprunt;
    private Date dateretour;
    private String commentaire;

    
}
