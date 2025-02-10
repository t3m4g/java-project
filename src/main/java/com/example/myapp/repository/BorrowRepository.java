package com.example.myapp.repository;

import com.example.myapp.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    // Rechercher un emprunt par utilisateur ou livre
    List<Borrow> findByUserIdOrBookId(Long userId, Long bookId);

//    // Vérifier le statut d'un emprunt (par exemple, si un livre est emprunté)
//    boolean existsByBookIdAndStatus(Long bookId, String status);
}