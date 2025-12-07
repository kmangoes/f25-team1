package com.example.CafeQuestBackendAPI.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.CafeQuestBackendAPI.repository.ReviewRepository;

@Service
public class ReviewsService {

@Autowired
private ReviewRepository reviewsRepository;
    
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
public Review addReview(Review review) {
    return reviewsRepository.save(review);
}
public void deleteReview(Long reviewId) {
    reviewsRepository.deleteById(reviewId);
}

}
