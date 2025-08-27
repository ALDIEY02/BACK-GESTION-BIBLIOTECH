package com.example.BACK_GESTION_BIBLIOTECH.service;

import java.util.List;

import com.example.BACK_GESTION_BIBLIOTECH.model.User;
import com.example.BACK_GESTION_BIBLIOTECH.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    
    public UserServiceImpl( UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long iduser) {
       return userRepository.findById(iduser).orElseThrow(() -> new RuntimeException("Utilisateur inexistant"));
    }
}
