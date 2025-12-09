package com.example.CafeQuestApiApplication.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "events")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private CoffeeShop coffeeShop;
    
    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false)
    private LocalDate eventDate;
    
    @Column(nullable = false)
    private LocalTime eventTime;
    
    @Column
    private Integer maxAttendees;
    
    @Column(nullable = false)
    private Integer currentAttendees = 1;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType eventType;
    
    @Column(nullable = false)
    private Boolean isPublic = true;
    
    @Column
    private String room;
    
    // Constructors
    public Event() {}
    
    public Event(String name, CoffeeShop coffeeShop, User organizer, 
            LocalDate eventDate, LocalTime eventTime, EventType eventType) {
        this.name = name;
        this.coffeeShop = coffeeShop;
        this.organizer = organizer;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventType = eventType;
    }
    
    // Getters and Setters
    public Long getEventId() {
        return eventId;
    }
    
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }
    
    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }
    
    public User getOrganizer() {
        return organizer;
    }
    
    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDate getEventDate() {
        return eventDate;
    }
    
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    
    public LocalTime getEventTime() {
        return eventTime;
    }
    
    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }
    
    public Integer getMaxAttendees() {
        return maxAttendees;
    }
    
    public void setMaxAttendees(Integer maxAttendees) {
        this.maxAttendees = maxAttendees;
    }
    
    public Integer getCurrentAttendees() {
        return currentAttendees;
    }
    
    public void setCurrentAttendees(Integer currentAttendees) {
        this.currentAttendees = currentAttendees;
    }
    
    public EventType getEventType() {
        return eventType;
    }
    
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    
    public Boolean getIsPublic() {
        return isPublic;
    }
    
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }
    
    public String getRoom() {
        return room;
    }
    
    public void setRoom(String room) {
        this.room = room;
    }
    
    public enum EventType {
        STUDY_GROUP, SOCIAL, COMPETITION, PERFORMANCE, OTHER
    }
}