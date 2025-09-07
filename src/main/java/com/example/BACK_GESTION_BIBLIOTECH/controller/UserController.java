package com.example.BACK_GESTION_BIBLIOTECH.controller;

import org.springframework.data.domain.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.BACK_GESTION_BIBLIOTECH.model.Profil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.example.BACK_GESTION_BIBLIOTECH.dto.UserRequest;
import com.example.BACK_GESTION_BIBLIOTECH.model.User;
import com.example.BACK_GESTION_BIBLIOTECH.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
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
        user.setNumero(request.getNumero());

        // Récupérer le profil par son nom (libelle)
        Profil profil = userService.findProfilByLibelle(request.getProfilNom());
        if (profil == null) {
            throw new RuntimeException("Profil avec le nom '" + request.getProfilNom() + "' non trouvé");
        }

        user.setProfil(profil);

        return userService.save(user);
    }
    @GetMapping
    public Map<String, Object> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int limit,
            @RequestParam(required = false) String name
    ) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<User> usersPage;

        if (name != null && !name.isEmpty()) {
            usersPage = userService.findByNameContaining(name, pageable);
        } else {
            usersPage = userService.findAllPaginated(pageable);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("data", usersPage.getContent());
        Map<String, Object> pagination = new HashMap<>();
        pagination.put("currentPage", usersPage.getNumber());
        pagination.put("total", usersPage.getTotalElements());
        pagination.put("totalPages", usersPage.getTotalPages());
        response.put("pagination", pagination);

        return response;
    }

}
