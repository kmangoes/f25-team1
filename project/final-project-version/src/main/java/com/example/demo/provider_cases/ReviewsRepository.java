package com.example.demo.provider_cases;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    
    @Query("SELECT r FROM Reviews r WHERE r.userName LIKE %?1%")
    List<Reviews> getReviewsByUserName(String userName);

}
