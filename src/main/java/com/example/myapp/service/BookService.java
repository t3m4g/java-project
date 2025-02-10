package com.example.myapp.service;

import com.example.myapp.entity.Book;
import com.example.myapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Ajouter un livre
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Afficher tous les livres
    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    // Afficher un livre par ID
    public Optional<Book> showBook(Long id) {
        return bookRepository.findById(id);
    }

    // Rechercher un livre par titre, auteur ou genre
    public List<Book> searchBook(String keyword) {
        return bookRepository.findByTitreContainingOrAuteurContainingOrGenreContaining(keyword, keyword, keyword);
    }

    // Mettre à jour un livre
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livre non trouvé"));
        book.setTitre(bookDetails.getTitre());
        book.setAuteur(bookDetails.getAuteur());
        book.setGenre(bookDetails.getGenre());
        book.setAnneePublication(bookDetails.getAnneePublication());
        book.setDisponibilite(bookDetails.isDisponibilite());
        return bookRepository.save(book);
    }

    // Supprimer un livre
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Vérifier la disponibilité d'un livre
    public boolean isDisponibilite(Long id) {
        return bookRepository.existsByIdAndDisponibiliteTrue(id);
    }
}