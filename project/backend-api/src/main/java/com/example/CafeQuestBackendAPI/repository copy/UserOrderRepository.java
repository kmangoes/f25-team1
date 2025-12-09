package com.example.CafeQuestApiApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestApiApplication.entity.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
    
    @Query("SELECT u FROM UserOrder u WHERE u.user.userId = ?1")
    List<UserOrder> findByUser_UserId(Long userId);
}