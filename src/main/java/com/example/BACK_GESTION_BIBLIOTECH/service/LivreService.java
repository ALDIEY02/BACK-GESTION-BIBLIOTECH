package com.example.BACK_GESTION_BIBLIOTECH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BACK_GESTION_BIBLIOTECH.model.Livre;
import com.example.BACK_GESTION_BIBLIOTECH.repository.LivreRepository;

@Service
@Transactional
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }

    public Optional<Livre> getLivreByIsbn(String isbn) {
        return livreRepository.findByIsbn(isbn);
    }

    public Optional<Livre> getLivreByTitre(String titre) {
        return livreRepository.findByTitre(titre);
    }

    public List<Livre> getLivresByAuteur(Long idAuteur) {
        return livreRepository.findByAuteur(idAuteur);
    }

    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public Livre updateBook(Long id, Livre livreDetails) {
        Livre livre = livreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        livre.setTitre(livreDetails.getTitre());
        livre.setIsbn(livreDetails.getIsbn());
        livre.setGenre(livreDetails.getGenre());
        livre.setDatepublication(livreDetails.getDatepublication());
        livre.setAuteur(livreDetails.getAuteur());
        livre.setTypeLivre(livreDetails.getTypeLivre());

        return livreRepository.save(livre);
    }

    public void deleteBook(Long id) {
        livreRepository.deleteById(id);
    }
}
