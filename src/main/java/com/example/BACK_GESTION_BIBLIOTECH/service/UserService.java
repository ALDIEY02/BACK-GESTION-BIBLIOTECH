package com.example.BACK_GESTION_BIBLIOTECH.service;

import java.util.List;


import com.example.BACK_GESTION_BIBLIOTECH.model.User;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User getUserById(Long iduser);
}
