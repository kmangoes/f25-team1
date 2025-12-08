package com.example.demo.provider_cases;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewsController {
    
@Autowired
private ReviewsService reviewsService;

@GetMapping("/reviews")
public Object getAllReviews() {
    return reviewsService.getAllReviews();
}
@GetMapping("/reviews/{id}")
public Object getReviewById(@PathVariable Long id) {
    return reviewsService.getReviewById(id);
}
@GetMapping("/reviews/userName")
public Object getReviewByUsername (@RequestParam String userName) {
    if (userName != null) {
        return reviewsService.getReviewByUsername(userName);
    } else {
        return reviewsService.getAllReviews();
    }
}
@PostMapping("/reviews")
public Reviews addReview(@RequestBody Reviews review) {
    return reviewsService.addReview(review);
}
@DeleteMapping("/reviews/{reviewId}")
public void deleteReview(@PathVariable Long reviewId) {
    reviewsService.deleteReview(reviewId);
}

}