package com.example.demo.backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {
    
    @Query("SELECT r FROM Review r WHERE r.user.username LIKE %?1%")
    List<Review> getReviewsByUserName(String userName);

}
