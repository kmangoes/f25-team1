package com.example.CafeQuestApiApplication.service;

import com.example.CafeQuestApiApplication.entity.User;
import com.example.CafeQuestApiApplication.entity.Profile;
import com.example.CafeQuestApiApplication.repository.UserRepository;
import com.example.CafeQuestApiApplication.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProfileRepository profileRepository;
    
    // Create new user (Sign Up)
    public User createUser(User user) {
        // Validate email ends with @uncg.edu
        if (!user.getEmail().endsWith("@uncg.edu")) {
            throw new IllegalArgumentException("Email must be a valid UNCG email (@uncg.edu)");
        }
        
        // Check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }
        
        // Set default status to PENDING
        user.setStatus(User.UserStatus.PENDING);
        user.setCreatedAt(LocalDateTime.now());
        
        // Save user
        User savedUser = userRepository.save(user);
        
        // Create default profile for user
        Profile profile = new Profile(savedUser);
        profileRepository.save(profile);
        
        return savedUser;
    }
    
    // Login - authenticate user
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        
        if (user.getStatus() == User.UserStatus.SUSPENDED) {
            throw new IllegalArgumentException("Account is suspended");
        }
        
        // Update last login
        user.setLastLogin(LocalDateTime.now());
        return userRepository.save(user);
    }
    
    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
    
    // Update user
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        
        if (userDetails.getFullName() != null) {
            user.setFullName(userDetails.getFullName());
        }
        if (userDetails.getStatus() != null) {
            user.setStatus(userDetails.getStatus());
        }
        
        return userRepository.save(user);
    }
    
    // Delete user
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}