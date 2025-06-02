package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.User;
import com.example.joblink_project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*") // pour autoriser les requêtes depuis Postman ou le front
public class UserController {

    @Autowired
    private UserService userService;

    // ▶️ 1. Inscription d’un utilisateur
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.sInscrire(user);
    }

    // ▶️ 2. Mise à jour du profil
    @PutMapping("/{id}")
    public User updateProfile(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.gererProfil(id, updatedUser);
    }

    // ▶️ 3. Rechercher emplois (placeholder pour l’instant)
    @GetMapping("/search-jobs")
    public List<?> searchJobs(@RequestParam String keyword) {
        return userService.rechercherEmplois(keyword);
    }

    // ▶️ 4. Afficher les infos d’un utilisateur (utile pour test)
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }
}
