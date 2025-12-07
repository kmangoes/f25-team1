package com.example.CafeQuestBackendAPI.service;

import com.example.CafeQuestBackendAPI.entity.Profile;
import com.example.CafeQuestBackendAPI.entity.User;
import com.example.CafeQuestBackendAPI.repository.ProfileRepository;
import com.example.CafeQuestBackendAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    
    @Autowired
    private ProfileRepository profileRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    // Get profile by user ID
    public Profile getProfileByUserId(Long userId) {
        return profileRepository.findByUser_UserId(userId)
            .orElseThrow(() -> new IllegalArgumentException("Profile not found for user"));
    }
    
    // Update profile
    public Profile updateProfile(Long userId, Profile profileDetails) {
        Profile profile = getProfileByUserId(userId);
        
        if (profileDetails.getMajor() != null) {
            profile.setMajor(profileDetails.getMajor());
        }
        if (profileDetails.getBio() != null) {
            profile.setBio(profileDetails.getBio());
        }
        if (profileDetails.getTheme() != null) {
            profile.setTheme(profileDetails.getTheme());
        }
        if (profileDetails.getPictureUrl() != null) {
            profile.setPictureUrl(profileDetails.getPictureUrl());
        }
        
        return profileRepository.save(profile);
    }
    
    // Create profile (used during user registration)
    public Profile createProfile(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        Profile profile = new Profile(user);
        return profileRepository.save(profile);
    }
}