package com.example.myapp.repository;

import com.example.myapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Rechercher un livre par titre, auteur ou genre
    List<Book> findByTitreContainingOrAuteurContainingOrGenreContaining(String titre, String auteur, String genre);

    // Vérifier la disponibilité d'un livre
    boolean existsByIdAndDisponibiliteTrue(Long id);
}