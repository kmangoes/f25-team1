package com.example.CafeQuestApiApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestApiApplication.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    @Query("SELECT r FROM Review r WHERE r.coffeeShop.shopId = ?1")
    List<Review> findByCoffeeShop_ShopId(Long shopId);

    @Query("SELECT r FROM Review r WHERE r.user.userId = ?1")
    List<Review> findByUser_UserId(Long userId);
}