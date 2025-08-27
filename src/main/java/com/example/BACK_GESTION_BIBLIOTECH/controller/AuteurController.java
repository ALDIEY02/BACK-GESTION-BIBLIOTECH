package com.example.BACK_GESTION_BIBLIOTECH.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BACK_GESTION_BIBLIOTECH.model.Auteur;
import com.example.BACK_GESTION_BIBLIOTECH.service.AuteurService;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/auteurs")
public class AuteurController {
    private final AuteurService auteurService;
    
    public AuteurController(AuteurService auteurService){
        this.auteurService = auteurService;
    }

    @GetMapping
    public List<Auteur> getAll() {
        return auteurService.findAll();
    }
    

    @PostMapping
    public Auteur create(@RequestBody Auteur auteur){
        return auteurService.save(auteur);
    }
}
