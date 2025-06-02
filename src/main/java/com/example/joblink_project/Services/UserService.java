package com.example.joblink_project.Services;

import com.example.joblink_project.Models.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User sInscrire(User user); // Register user
    User gererProfil(Long userId, User updatedUser); // Update user profile
    List<?> rechercherEmplois(String keyword); // Return a list of jobs (you can define the Job entity later)
    Optional<User> getUserById(Long id); // Additional helper
}
