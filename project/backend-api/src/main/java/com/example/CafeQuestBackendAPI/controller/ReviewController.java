package com.example.CafeQuestApiApplication.controller;

import com.example.CafeQuestApiApplication.entity.Review;
import com.example.CafeQuestApiApplication.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;
    
    // Create new review
    @PostMapping("/user/{userId}/shop/{shopId}")
    public ResponseEntity<?> createReview(
            @PathVariable Long userId,
            @PathVariable Long shopId,
            @RequestBody Review review) {
        try {
            Review created = reviewService.createReview(userId, shopId, review);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    // Get all reviews for a coffee shop
    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<Review>> getReviewsByShop(@PathVariable Long shopId) {
        List<Review> reviews = reviewService.getReviewsByShopId(shopId);
        return ResponseEntity.ok(reviews);
    }
    
    // Get all reviews by a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable Long userId) {
        List<Review> reviews = reviewService.getReviewsByUserId(userId);
        return ResponseEntity.ok(reviews);
    }
    
    // Get review by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
        try {
            Review review = reviewService.getReviewById(id);
            return ResponseEntity.ok(review);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    // Delete review
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id) {
        try {
            reviewService.deleteReview(id);
            return ResponseEntity.ok("Review deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}