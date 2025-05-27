package com.example.authservice.controller;

import com.example.authservice.model.AppUser;
import com.example.authservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // ✅ Add your frontend URL here
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        String username = authentication.getName(); // Extracted from JWT token

        Optional<AppUser> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            AppUser user = optionalUser.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
