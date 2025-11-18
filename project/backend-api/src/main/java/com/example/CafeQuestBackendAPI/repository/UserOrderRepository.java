/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.CafeQuestBackendAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestBackendAPI.entity.UserOrder;

@Repository
public interface UserOrderRepository  extends JpaRepository<UserOrder, Long> {
    
    @Query("SELECT u FROM UserOrder u WHERE u.user.userId = ?1")
    List<UserOrder> findByUser_UserId(Long userId);

}
