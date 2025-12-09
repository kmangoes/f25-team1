package com.example.CafeQuestApiApplication.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "coffee_shops")
public class CoffeeShop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String address;
    
    @Column(precision = 10, scale = 7)
    private BigDecimal latitude;
    
    @Column(precision = 10, scale = 7)
    private BigDecimal longitude;
    
    @Column
    private String phone;
    
    @Column
    private String website;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal averageRating = BigDecimal.ZERO;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal studyScore = BigDecimal.ZERO;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal comfortScore = BigDecimal.ZERO;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal accessibilityScore = BigDecimal.ZERO;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal coffeeQualityScore = BigDecimal.ZERO;
    
    @Column
    private Integer totalRatings = 0;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    // Constructors
    public CoffeeShop() {}
    
    public CoffeeShop(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    // Getters and Setters
    public Long getShopId() {
        return shopId;
    }
    
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public BigDecimal getLatitude() {
        return latitude;
    }
    
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
    
    public BigDecimal getLongitude() {
        return longitude;
    }
    
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
    public BigDecimal getAverageRating() {
        return averageRating;
    }
    
    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }
    
    public BigDecimal getStudyScore() {
        return studyScore;
    }
    
    public void setStudyScore(BigDecimal studyScore) {
        this.studyScore = studyScore;
    }
    
    public BigDecimal getComfortScore() {
        return comfortScore;
    }
    
    public void setComfortScore(BigDecimal comfortScore) {
        this.comfortScore = comfortScore;
    }
    
    public BigDecimal getAccessibilityScore() {
        return accessibilityScore;
    }
    
    public void setAccessibilityScore(BigDecimal accessibilityScore) {
        this.accessibilityScore = accessibilityScore;
    }
    
    public BigDecimal getCoffeeQualityScore() {
        return coffeeQualityScore;
    }
    
    public void setCoffeeQualityScore(BigDecimal coffeeQualityScore) {
        this.coffeeQualityScore = coffeeQualityScore;
    }
    
    public Integer getTotalRatings() {
        return totalRatings;
    }
    
    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}