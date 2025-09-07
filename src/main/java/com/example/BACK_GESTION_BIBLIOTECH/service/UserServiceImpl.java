package com.example.BACK_GESTION_BIBLIOTECH.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import com.example.BACK_GESTION_BIBLIOTECH.model.Profil;
import com.example.BACK_GESTION_BIBLIOTECH.repository.ProfilRepository;
import com.example.BACK_GESTION_BIBLIOTECH.model.User;
import com.example.BACK_GESTION_BIBLIOTECH.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProfilRepository profilRepository;

    // ✅ Constructeur unique avec les deux repositories
    public UserServiceImpl(UserRepository userRepository, ProfilRepository profilRepository) {
        this.userRepository = userRepository;
        this.profilRepository = profilRepository;
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
        return userRepository.findById(iduser)
                .orElseThrow(() -> new RuntimeException("Utilisateur inexistant"));
    }

    @Override
    public Profil findProfilByLibelle(String libelle) {
        return profilRepository.findByRole(libelle)
                .orElseThrow(() -> new RuntimeException("Profil avec le rôle '" + libelle + "' non trouvé"));
    }

    @Override
    public Page<User> findAllPaginated(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> findByNameContaining(String name, Pageable pageable) {
        return userRepository.findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(name, name, pageable);
    }

}
