package com.example.CafeQuestApiApplication.controller;

import com.example.CafeQuestApiApplication.entity.Profile;
import com.example.CafeQuestApiApplication.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "*")
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;
    
    // Get profile by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable Long userId) {
        try {
            Profile profile = profileService.getProfileByUserId(userId);
            return ResponseEntity.ok(profile);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    // Update profile
    @PutMapping("/user/{userId}")
    public ResponseEntity<?> updateProfile(@PathVariable Long userId, @RequestBody Profile profile) {
        try {
            Profile updatedProfile = profileService.updateProfile(userId, profile);
            return ResponseEntity.ok(updatedProfile);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}