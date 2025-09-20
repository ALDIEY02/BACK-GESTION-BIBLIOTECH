package com.example.BACK_GESTION_BIBLIOTECH.model;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "typeLivre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Livre> livres =  new ArrayList<>();
}
