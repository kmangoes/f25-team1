/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.CafeQuestBackendAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestBackendAPI.entity.Event;


@Repository
public interface EventRepository  extends JpaRepository<Event, Long> {

    // Custom query for fetching events by organizer's userId
    @Query("SELECT e FROM Event e WHERE e.organizer.userId = ?1")
    List<Event> findByOrganizer_UserId(Long userId);

    // Custom query for fetching events by shop's shopId
    @Query("SELECT e FROM Event e WHERE e.coffeeShop.shopId = ?1")
    List<Event> findByCoffeeShop_ShopId(Long shopId);

}
