package com.example.BACK_GESTION_BIBLIOTECH.model;

import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;

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
    private String isbn;
    private String titre;
    private Date datepublication;
    private boolean disponible;
    private String genre;
    private int stock;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idAuteur", nullable=false)
    private Auteur idAuteur;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idTypeLivre", nullable=false)
    private TypeLivre typeLivre;
}
