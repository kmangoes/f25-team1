package com.example.demo.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ReviewsService {

@Autowired
private CafesRepository cafesRepository;
@Autowired
private ReviewsRepository reviewsRepository;
    
//endpoint mapping methods
public Object getAllReviews() {
    return reviewsRepository.findAll();
}
public List<Review> getReviewByCafeId(Long cafeId) {
    return reviewsRepository.findByCafeCafeId(cafeId);
}
public Object getReviewByUsername(String userName){
    return reviewsRepository.getReviewsByUserName(userName);
}
public Review addReview(Review review) {
    Long cafe_id = review.getCafe().getCafeId();
    Cafes existingCafe = cafesRepository.findById(cafe_id).orElseThrow(() -> new IllegalArgumentException("Cafe not found with id: " + cafe_id));

    review.setCafe(existingCafe); // associate the review with the existing cafe
    return reviewsRepository.save(review);
}
public void deleteReview(Long reviewId) {
    reviewsRepository.deleteById(reviewId);
}

}