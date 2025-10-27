package com.example.CafeQuestBackendAPI.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_attendees")
public class EventAttendee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RsvpStatus rsvpStatus = RsvpStatus.GOING;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime rsvpDate = LocalDateTime.now();
    
    // Constructors
    public EventAttendee() {}
    
    public EventAttendee(Event event, User user, RsvpStatus rsvpStatus) {
        this.event = event;
        this.user = user;
        this.rsvpStatus = rsvpStatus;
    }
    
    // Getters and Setters
    public Long getAttendanceId() {
        return attendanceId;
    }
    
    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }
    
    public Event getEvent() {
        return event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public RsvpStatus getRsvpStatus() {
        return rsvpStatus;
    }
    
    public void setRsvpStatus(RsvpStatus rsvpStatus) {
        this.rsvpStatus = rsvpStatus;
    }
    
    public LocalDateTime getRsvpDate() {
        return rsvpDate;
    }
    
    public void setRsvpDate(LocalDateTime rsvpDate) {
        this.rsvpDate = rsvpDate;
    }
    
    public enum RsvpStatus {
        GOING, MAYBE, NOT_GOING
    }
}