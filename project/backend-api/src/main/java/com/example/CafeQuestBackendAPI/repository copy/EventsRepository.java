package com.example.CafeQuestApiApplication.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestBackendAPI.entity.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

    @Query("SELECT a FROM Events a WHERE a.eventName LIKE %?1%")
    List<Events> getEventByName(String eventName);
    
}
