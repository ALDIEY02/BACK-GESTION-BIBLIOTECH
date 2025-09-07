package com.example.BACK_GESTION_BIBLIOTECH.service;

import org.springframework.data.domain.Pageable;
import java.util.List;


import com.example.BACK_GESTION_BIBLIOTECH.model.Profil;
import com.example.BACK_GESTION_BIBLIOTECH.model.User;
import org.springframework.data.domain.Page;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User getUserById(Long iduser);
    Profil findProfilByLibelle(String libelle);

    Page<User> findAllPaginated(Pageable pageable);
    Page<User> findByNameContaining(String name, Pageable pageable);

}
