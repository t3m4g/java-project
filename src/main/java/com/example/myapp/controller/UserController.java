package com.example.myapp.controller;

import com.example.myapp.entity.User;
import com.example.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users") // Base path pour toutes les routes de ce contrôleur
public class UserController {

    @Autowired
    private UserService userService;

    // Route: POST /api/users
    @PostMapping("/create_user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // Route: GET /api/users
    @GetMapping("/show_all_users")
    public List<User> showAllUsers() {
        return userService.showAllUsers();
    }
//    public String showAllUsers(Model model) {
//        List<User> users = userService.showAllUsers();
//        System.out.println("Utilisateurs envoyés au frontend : " + users);
//        model.addAttribute("users", users);
//        return "users/list";
//    }

    // Route: GET /api/users/{id}
    @GetMapping("/show_user/{id}")
    public Optional<User> showUser(@PathVariable Long id) {
        return userService.showUser(id);
    }

    // Route: GET /api/users/search?keyword={keyword}
    @GetMapping("/search")
    public List<User> searchUser(@RequestParam String keyword) {
        return userService.searchUser(keyword);
    }

    // Route: PUT /api/users/{id}
    @PutMapping("/update_user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // Route: DELETE /api/users/{id}
    @DeleteMapping("/delete_user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}