package com.example.CafeQuestBackendAPI.provider_cases;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


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

}
