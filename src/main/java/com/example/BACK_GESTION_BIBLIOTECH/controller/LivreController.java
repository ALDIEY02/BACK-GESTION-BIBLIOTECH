package com.example.BACK_GESTION_BIBLIOTECH.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/livres")
public class LivreController {

    @GetMapping 
    public String listLivres(){
        return "Hello world!";
    }

    

}
