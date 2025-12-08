package com.example.demo.provider_cases;

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
public Object getReviewById(@PathVariable Long id) {
    return reviewsRepository.findById(id);
}
public Object getReviewByUsername(String userName){
    return reviewsRepository.getReviewsByUserName(userName);
}
public Reviews addReview(Reviews review) {
    Long cafe_id = review.getCafe().getCafeId();
    Cafes existingCafe = cafesRepository.findById(cafe_id).orElseThrow(() -> new IllegalArgumentException("Cafe not found with id: " + cafe_id));

    review.setCafe(existingCafe); // associate the review with the existing cafe
    return reviewsRepository.save(review);
}
public void deleteReview(Long reviewId) {
    reviewsRepository.deleteById(reviewId);
}

}