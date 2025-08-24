package com.example.BACK_GESTION_BIBLIOTECH.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeLivre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long Id;
    private String libelle;
    private String slug;
}
