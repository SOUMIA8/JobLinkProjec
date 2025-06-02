package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.User;
import com.example.joblink_project.Repositories.UserRepository;
import com.example.joblink_project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // s'inscrire
    @Override
    public User sInscrire(User user) {
        // Optional: check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }
        user.setActive(true); // or false depending on your activation flow
        return userRepository.save(user);
    }

    // gérer le profil
    @Override
    public User gererProfil(Long userId, User updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setPhone(updatedUser.getPhone());
        // Don't update password/email here unless specifically allowed
        return userRepository.save(user);
    }

    // rechercher des emplois
    @Override
    public List<?> rechercherEmplois(String keyword) {
        // You should implement this once you have a Job entity and JobRepository
        // return jobRepository.searchByKeyword(keyword);
        throw new UnsupportedOperationException("Search jobs not implemented yet");
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
