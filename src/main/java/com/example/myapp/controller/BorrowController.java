package com.example.myapp.controller;

import com.example.myapp.entity.Borrow;
import com.example.myapp.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrows") // Base path pour toutes les routes de ce contrôleur
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    // Route: POST /api/borrows
    @PostMapping("/create_borrow")
    public Borrow addBorrow(@RequestBody Borrow borrow) {
        return borrowService.addBorrow(borrow);
    }

    // Route: DELETE /api/borrows/{id}
    @DeleteMapping("/delete_borrow/{id}")
    public void deleteBorrow(@PathVariable Long id) {
        borrowService.deleteBorrow(id);
    }

    // Route: PUT /api/borrows/{id}/recover
    @PutMapping("/{id}/recover")
    public Borrow recoverBorrow(@PathVariable Long id) {
        return borrowService.recoverBorrow(id);
    }

    // Route: GET /api/borrows/search?userId={userId}&bookId={bookId}
    @GetMapping("/search")
    public List<Borrow> searchBorrow(@RequestParam(required = false) Long userId, @RequestParam(required = false) Long bookId) {
        return borrowService.searchBorrow(userId, bookId);
    }

    // Route: GET /api/borrows
    @GetMapping("/show_all_borrow")
    public List<Borrow> showAllBorrows() {
        return borrowService.showAllBorrows();
    }

    // Route: GET /api/borrows/{id}
    @GetMapping("/show_borrow/{id}")
    public Optional<Borrow> showBorrow(@PathVariable Long id) {
        return borrowService.showBorrow(id);
    }

    // Route: PUT /api/borrows/{id}
    @PutMapping("/update_borrow/{id}")
    public Borrow updateBorrow(@PathVariable Long id, @RequestBody Borrow borrowDetails) {
        return borrowService.updateBorrow(id, borrowDetails);
    }

    // Route: GET /api/borrows/{id}/status
    @GetMapping("/{id}/status")
    public String statusBorrow(@PathVariable Long id) {
        return borrowService.statusBorrow(id);
    }
}