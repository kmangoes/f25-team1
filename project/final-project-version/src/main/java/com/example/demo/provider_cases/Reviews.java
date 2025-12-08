package com.example.demo.provider_cases;
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
public class Reviews {
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

    /* json requests must include cafe { cafeId : __} of the desired cafe*/
    @ManyToOne
    @JoinColumn(name = "cafeId", nullable=false)
    private Cafes cafe; 

    public Reviews() { } //empty constructor for JPA

    public Reviews(String userName, String reviewText, int starRating, String reviewDate, Cafes cafe) {
        this.userName = userName;
        this.reviewText = reviewText;
        this.starRating = starRating;
        this.reviewDate = reviewDate;
        this.cafe = cafe;
    }
    public Reviews(Long reviewId, String userName, String reviewText, int starRating, String reviewDate, Cafes cafe) {
        this.reviewId = reviewId;
        this.userName = userName;
        this.reviewText = reviewText;
        this.starRating = starRating;
        this.reviewDate = reviewDate;
        this.cafe = cafe; 
    }

    public Long getReviewId() {
        return reviewId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
}
