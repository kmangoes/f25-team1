package com.example.demo.backend;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    @Column(nullable = false)
    private String reviewText;
    @Column(nullable = false) 
    private int starRating;

    @Column 
    private String reviewDate;

    /* json requests must include cafe { cafeId : __} of the desired cafe*/
    @ManyToOne
    @JoinColumn(name = "cafeId", nullable=false)
    private Cafes cafe; 
    @ManyToOne
    @JoinColumn(name = "userId", nullable=false)
    private User user;

    public Review() { } //empty constructor for JPA

    public Review(String reviewText, int starRating, String reviewDate, Cafes cafe, User user) {
        this.reviewText = reviewText;
        this.starRating = starRating;
        this.reviewDate = reviewDate;
        this.cafe = cafe;
        this.user = user;
    }
    public Review(Long reviewId, String reviewText, int starRating, String reviewDate, Cafes cafe, User user) {
        this.reviewId = reviewId;
        this.reviewText = reviewText;
        this.starRating = starRating;
        this.reviewDate = reviewDate;
        this.cafe = cafe; 
        this.user = user;
    }

    public Long getReviewId() {
        return reviewId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public String getReviewText() {
        return reviewText;
    }
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
    public int getStarRating() {
        return starRating;
    }
    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
    public String getReviewDate() {
        return reviewDate;
    }
    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }
    public Cafes getCafe() {
        return cafe; 
    }
    public void setCafe(Cafes cafe) {
        this.cafe = cafe; 
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
