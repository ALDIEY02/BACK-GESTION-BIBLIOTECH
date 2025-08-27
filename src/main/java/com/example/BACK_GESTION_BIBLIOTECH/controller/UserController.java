package com.example.BACK_GESTION_BIBLIOTECH.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BACK_GESTION_BIBLIOTECH.dto.UserRequest;
import com.example.BACK_GESTION_BIBLIOTECH.model.User;
import com.example.BACK_GESTION_BIBLIOTECH.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody UserRequest request){
        User user = new User();

        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setEmail(request.getEmail());
        user.setAdresse(request.getAdresse());
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        user.setCodeuser(request.getCodeuser());

        // Profil à créer

       return userService.save(user);
    }
    
}
