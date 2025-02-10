package com.example.myapp.service;

import com.example.myapp.entity.Borrow;
import com.example.myapp.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    // Ajouter un emprunt
    public Borrow addBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    // Supprimer un emprunt
    public void deleteBorrow(Long id) {
        borrowRepository.deleteById(id);
    }

    // Récupérer un emprunt (marquer comme retourné)
    public Borrow recoverBorrow(Long id) {
        Borrow borrow = borrowRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprunt non trouvé"));
        borrow.setBorrowStatus(Borrow.BorrowStatus.valueOf("TERMINE")); // Mettre à jour le statut
        return borrowRepository.save(borrow);
    }

    // Rechercher un emprunt par utilisateur ou livre
    public List<Borrow> searchBorrow(Long userId, Long bookId) {
        return borrowRepository.findByUserIdOrBookId(userId, bookId);
    }

    // Afficher tous les emprunts
    public List<Borrow> showAllBorrows() {
        return borrowRepository.findAll();
    }

    // Afficher un emprunt par ID
    public Optional<Borrow> showBorrow(Long id) {
        return borrowRepository.findById(id);
    }

    // Mettre à jour un emprunt
    public Borrow updateBorrow(Long id, Borrow borrowDetails) {
        Borrow borrow = borrowRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprunt non trouvé"));
        borrow.setUser(borrowDetails.getUser());
        borrow.setBook(borrowDetails.getBook());
        borrow.setBorrowStatus(borrowDetails.getBorrowStatus());
        return borrowRepository.save(borrow);
    }

    // Vérifier le statut d'un emprunt
    public String statusBorrow(Long id) {
        Borrow borrow = borrowRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprunt non trouvé"));
        return String.valueOf(borrow.getBorrowStatus());
    }
}