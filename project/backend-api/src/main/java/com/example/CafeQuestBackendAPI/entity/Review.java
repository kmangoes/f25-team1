package com.example.CafeQuestApiApplication.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private CoffeeShop coffeeShop;
    
    @Column(columnDefinition = "TEXT")
    private String reviewText;
    
    @Column(nullable = false)
    private Integer studyRating;
    
    @Column(nullable = false)
    private Integer comfortRating;
    
    @Column(nullable = false)
    private Integer accessibilityRating;
    
    @Column(nullable = false)
    private Integer coffeeQualityRating;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal overallRating;
    
    @Column
    private LocalDate visitDate;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    // Constructors
    public Review() {}
    
    public Review(User user, CoffeeShop coffeeShop, Integer studyRating, 
                  Integer comfortRating, Integer accessibilityRating, 
                  Integer coffeeQualityRating) {
        this.user = user;
        this.coffeeShop = coffeeShop;
        this.studyRating = studyRating;
        this.comfortRating = comfortRating;
        this.accessibilityRating = accessibilityRating;
        this.coffeeQualityRating = coffeeQualityRating;
        this.calculateOverallRating();
    }
    
    // Calculate overall rating as average of four ratings
    public void calculateOverallRating() {
        double avg = (studyRating + comfortRating + accessibilityRating + coffeeQualityRating) / 4.0;
        this.overallRating = BigDecimal.valueOf(avg);
    }
    
    // Getters and Setters
    public Long getReviewId() {
        return reviewId;
    }
    
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }
    
    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }
    
    public String getReviewText() {
        return reviewText;
    }
    
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
    
    public Integer getStudyRating() {
        return studyRating;
    }
    
    public void setStudyRating(Integer studyRating) {
        this.studyRating = studyRating;
    }
    
    public Integer getComfortRating() {
        return comfortRating;
    }
    
    public void setComfortRating(Integer comfortRating) {
        this.comfortRating = comfortRating;
    }
    
    public Integer getAccessibilityRating() {
        return accessibilityRating;
    }
    
    public void setAccessibilityRating(Integer accessibilityRating) {
        this.accessibilityRating = accessibilityRating;
    }
    
    public Integer getCoffeeQualityRating() {
        return coffeeQualityRating;
    }
    
    public void setCoffeeQualityRating(Integer coffeeQualityRating) {
        this.coffeeQualityRating = coffeeQualityRating;
    }
    
    public BigDecimal getOverallRating() {
        return overallRating;
    }
    
    public void setOverallRating(BigDecimal overallRating) {
        this.overallRating = overallRating;
    }
    
    public LocalDate getVisitDate() {
        return visitDate;
    }
    
    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}