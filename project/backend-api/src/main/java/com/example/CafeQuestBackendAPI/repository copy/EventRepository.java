package com.example.CafeQuestApiApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestApiApplication.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.organizer.userId = ?1")
    List<Event> findByOrganizer_UserId(Long userId);

    @Query("SELECT e FROM Event e WHERE e.coffeeShop.shopId = ?1")
    List<Event> findByCoffeeShop_ShopId(Long shopId);
}