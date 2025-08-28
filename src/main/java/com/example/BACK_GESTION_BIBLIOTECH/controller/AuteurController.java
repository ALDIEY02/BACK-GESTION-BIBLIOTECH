package com.example.BACK_GESTION_BIBLIOTECH.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BACK_GESTION_BIBLIOTECH.dto.AuteurRequest;
import com.example.BACK_GESTION_BIBLIOTECH.model.Auteur;
import com.example.BACK_GESTION_BIBLIOTECH.model.User;
import com.example.BACK_GESTION_BIBLIOTECH.service.AuteurService;
import com.example.BACK_GESTION_BIBLIOTECH.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/auteurs")
public class AuteurController {
    private final AuteurService auteurService;
    private final UserService userService;
    
    public AuteurController(AuteurService auteurService, UserService userService){
        this.auteurService = auteurService;
        this.userService = userService;
    }

    @GetMapping
    public List<Auteur> getAll() {
        return auteurService.findAll();
    }
    

    @PostMapping
    public Auteur create(@RequestBody AuteurRequest request){

        System.out.println("Created by: "+request.getCreatedBy());

        User user = userService.getUserById(request.getCreatedBy());
        System.out.println("User: "+user);

        Auteur auteur = new Auteur();
        auteur.setNom(request.getNom());
        auteur.setPrenom(request.getPrenom());
        auteur.setEmail(request.getEmail());
        auteur.setNationalite(request.getNationalite());
        auteur.setResume(request.getResume());
        auteur.setCreatedBy(user);

        return auteurService.save(auteur);
    }
}
