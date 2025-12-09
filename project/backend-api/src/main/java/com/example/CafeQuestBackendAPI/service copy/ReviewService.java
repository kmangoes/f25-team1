package com.example.CafeQuestApiApplication.service;

import com.example.CafeQuestApiApplication.entity.Review;
import com.example.CafeQuestApiApplication.entity.CoffeeShop;
import com.example.CafeQuestApiApplication.entity.User;
import com.example.CafeQuestApiApplication.repository.ReviewRepository;
import com.example.CafeQuestApiApplication.repository.CoffeeShopRepository;
import com.example.CafeQuestApiApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private CoffeeShopRepository coffeeShopRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    // Create new review
    public Review createReview(Long userId, Long shopId, Review review) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        CoffeeShop shop = coffeeShopRepository.findById(shopId)
            .orElseThrow(() -> new IllegalArgumentException("Coffee shop not found"));
        
        // Validate ratings are between 1-5
        validateRating(review.getStudyRating());
        validateRating(review.getComfortRating());
        validateRating(review.getAccessibilityRating());
        validateRating(review.getCoffeeQualityRating());
        
        review.setUser(user);
        review.setCoffeeShop(shop);
        review.calculateOverallRating();
        
        Review savedReview = reviewRepository.save(review);
        
        // Update shop ratings
        updateShopRatings(shop);
        
        return savedReview;
    }
    
    private void validateRating(Integer rating) {
        if (rating == null || rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }
    
    // Update shop aggregate ratings
    private void updateShopRatings(CoffeeShop shop) {
        List<Review> reviews = reviewRepository.findByCoffeeShop_ShopId(shop.getShopId());
        
        if (reviews.isEmpty()) {
            return;
        }
        
        double avgStudy = reviews.stream()
            .mapToInt(Review::getStudyRating)
            .average()
            .orElse(0.0);
        
        double avgComfort = reviews.stream()
            .mapToInt(Review::getComfortRating)
            .average()
            .orElse(0.0);
        
        double avgAccessibility = reviews.stream()
            .mapToInt(Review::getAccessibilityRating)
            .average()
            .orElse(0.0);
        
        double avgCoffee = reviews.stream()
            .mapToInt(Review::getCoffeeQualityRating)
            .average()
            .orElse(0.0);
        
        double avgOverall = (avgStudy + avgComfort + avgAccessibility + avgCoffee) / 4.0;
        
        shop.setStudyScore(BigDecimal.valueOf(avgStudy).setScale(2, RoundingMode.HALF_UP));
        shop.setComfortScore(BigDecimal.valueOf(avgComfort).setScale(2, RoundingMode.HALF_UP));
        shop.setAccessibilityScore(BigDecimal.valueOf(avgAccessibility).setScale(2, RoundingMode.HALF_UP));
        shop.setCoffeeQualityScore(BigDecimal.valueOf(avgCoffee).setScale(2, RoundingMode.HALF_UP));
        shop.setAverageRating(BigDecimal.valueOf(avgOverall).setScale(2, RoundingMode.HALF_UP));
        shop.setTotalRatings(reviews.size());
        
        coffeeShopRepository.save(shop);
    }
    
    // Get all reviews for a shop
    public List<Review> getReviewsByShopId(Long shopId) {
        return reviewRepository.findByCoffeeShop_ShopId(shopId);
    }
    
    // Get all reviews by a user
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUser_UserId(userId);
    }
    
    // Get review by ID
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Review not found"));
    }
    
    // Delete review
    public void deleteReview(Long id) {
        Review review = getReviewById(id);
        CoffeeShop shop = review.getCoffeeShop();
        reviewRepository.delete(review);
        
        // Update shop ratings after deletion
        updateShopRatings(shop);
    }
}