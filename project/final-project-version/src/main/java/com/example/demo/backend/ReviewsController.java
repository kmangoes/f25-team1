package com.example.demo.backend;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ReviewsController {

@Autowired
private UserService userService;
@Autowired
private ReviewsService reviewsService;
@Autowired
private CafeService cafeService;

@GetMapping("/reviews")
public Object getAllReviews() {
    return reviewsService.getAllReviews();
}
@GetMapping("/reviews/userName")
public Object getReviewByUsername (@RequestParam String userName) {
    if (userName != null) {
        return reviewsService.getReviewByUsername(userName);
    } else {
        return reviewsService.getAllReviews();
    }
}


@GetMapping("/users/reviews/{cafeId}/add")
public String showAddReviewForm(@PathVariable Long cafeId, Model model) {
    Cafes cafe = cafeService.getCafeById(cafeId);
    model.addAttribute("cafe", cafe);
    model.addAttribute("review", new Review());
    return "user_leave_reviews"; // returns user_leave_reviews.ftlh
}
@PostMapping("/users/reviews/{cafeId}")
public String addReview(@ModelAttribute Review review, @PathVariable Long cafeId, Principal principal) {
    User user = userService.getByUsername(principal.getName());
    Cafes cafe = cafeService.getCafeById(cafeId);
    review.setUser(user);
    review.setCafe(cafe);
    reviewsService.addReview(review);
    return "redirect:/users/reviewsPage/" + cafeId;
}



@DeleteMapping("/reviews/{reviewId}")
public void deleteReview(@PathVariable Long reviewId) {
    reviewsService.deleteReview(reviewId);
}
@GetMapping("/users/reviewsPage/{cafeId}")
public String getUserReviewByCafeId(@PathVariable Long cafeId, Model model) {
    Cafes cafe = cafeService.getCafeById(cafeId);
    model.addAttribute("cafe", cafe);
    List<Review> reviews = reviewsService.getReviewByCafeId(cafeId);
    model.addAttribute("reviews", reviews);
    return "user_reviews"; // returns user_reviews.ftlh
}
@GetMapping("/providers/reviewsPage/{cafeId}")
public String getProvReviewByCafeId(@PathVariable Long cafeId, Model model) {
    Cafes cafe = cafeService.getCafeById(cafeId);
    List<Review> reviews = reviewsService.getReviewByCafeId(cafeId);
    model.addAttribute("cafe", cafe);
    model.addAttribute("reviews", reviews);
    return "prov_reviews"; // returns prov_reviews.ftlh
}

}