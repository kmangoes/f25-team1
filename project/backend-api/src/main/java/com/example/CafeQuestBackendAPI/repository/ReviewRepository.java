package com.example.CafeQuestBackendAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestBackendAPI.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    @Query("SELECT r FROM Review r WHERE r.user.fullName LIKE %?1%")
    List<Review> getReviewsByUserName(String userName);

    @Query("SELECT r FROM Review r WHERE r.coffeeShop.shopId = ?1")
    List<Review> findByCoffeeShop_ShopId(Long shopId);

    @Query("SELECT r FROM Review r WHERE r.user.userId = ?1")
    List<Review> findByUser_UserId(Long userId);

}
