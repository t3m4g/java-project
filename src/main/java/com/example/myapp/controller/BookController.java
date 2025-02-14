package com.example.myapp.controller;

import com.example.myapp.entity.Book;
import com.example.myapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books") // Base path pour toutes les routes de ce contrôleur
public class BookController {

    @Autowired
    private BookService bookService;

    // Route: POST /api/books
    @PostMapping("/create_book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // Route: GET /api/books
    @GetMapping("/show_all_book")
    public List<Book> showAllBooks() {
        return bookService.showAllBooks();
    }

    // Route: GET /api/books/{id}
    @GetMapping("/show_book/{id}")
    public Optional<Book> showBook(@PathVariable Long id) {
        return bookService.showBook(id);
    }

    // Route: GET /api/books/search?keyword={keyword}
    @GetMapping("/search")
    public List<Book> searchBook(@RequestParam String keyword) {
        return bookService.searchBook(keyword);
    }

    // Route: PUT /api/books/{id}
    @PutMapping("/update_book/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }

    // Route: DELETE /api/books/{id}
    @DeleteMapping("/delete_book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    // Route: GET /api/books/{id}/disponibilite
    @GetMapping("/{id}/disponibilite")
    public boolean isDisponibilite(@PathVariable Long id) {
        return bookService.isDisponibilite(id);
    }
}