package com.example.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // Page d'accueil
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Routes pour les utilisateurs
    @GetMapping("/users")
    public String userList() {
        return "users/list";
    }

    @GetMapping("/users/add")
    public String addUser() {
        return "users/add";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser() {
        return "users/edit";
    }

    @GetMapping("/users/search")
    public String searchUser() {
        return "users/search";
    }

    // Routes pour les livres
    @GetMapping("/books")
    public String bookList() {
        return "books/list";
    }

    @GetMapping("/books/add")
    public String addBook() {
        return "books/add";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook() {
        return "books/edit";
    }

    @GetMapping("/books/search")
    public String searchBook() {
        return "books/search";
    }

    // Routes pour les emprunts
    @GetMapping("/borrows")
    public String borrowList() {
        return "borrows/list";
    }

    @GetMapping("/borrows/add")
    public String addBorrow() {
        return "borrows/add";
    }

    @GetMapping("/borrows/edit/{id}")
    public String editBorrow() {
        return "borrows/edit";
    }

    @GetMapping("/borrows/search")
    public String searchBorrow() {
        return "borrows/search";
    }
}