package com.example.CafeQuestApiApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestApiApplication.entity.EventAttendee;

@Repository
public interface EventAttendeeRepository extends JpaRepository<EventAttendee, Long> {

    @Query("SELECT a FROM EventAttendee a WHERE a.event.eventId = ?1 AND a.user.userId = ?2")
    Optional<EventAttendee> findByEvent_EventIdAndUser_UserId(Long eventId, Long userId);

    @Query("SELECT a FROM EventAttendee a WHERE a.user.userId = ?1")
    List<EventAttendee> findByUser_UserId(Long userId);
}