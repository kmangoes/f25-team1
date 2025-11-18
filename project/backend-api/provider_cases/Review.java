package com.example.CafeQuestBackendAPI.provider_cases;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String reviewText;
    @Column(nullable = false) 
    private int starRating;
    @Column 
    private String reviewDate;

    public Review() { } //empty constructor for JPA

    public Review(String userName, String reviewText, int starRating, String reviewDate) {
        this.userName = userName;
        this.reviewText = reviewText;
        this.starRating = starRating;
        this.reviewDate = reviewDate;
    }
    public Review(Long reviewId, String userName, String reviewText, int starRating, String reviewDate) {
        this.reviewId = reviewId;
        this.userName = userName;
        this.reviewText = reviewText;
        this.starRating = starRating;
        this.reviewDate = reviewDate;
    }

    public Long getReviewId(Long reviewId) {
        return reviewId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public String getUserName(String userName) {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getReviewText(String reviewText) {
        return reviewText;
    }
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
    public int getStarRating(int starRating) {
        return starRating;
    }
    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
    public String getReviewDate(String reviewDate) {
        return reviewDate;
    }
    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }
    
}
