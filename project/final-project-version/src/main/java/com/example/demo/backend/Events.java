package com.example.demo.backend;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column (nullable = false, name = "eventName")
    private String eventName;
    @Column (nullable = false)
    private String eventType;
    @Column (nullable = false)
    private String eventDate;
    @Column (nullable = false)
    private String description;
    @Column (nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "creatorId")
    private User creator;
    @ManyToMany
    @JoinTable(
        name = "event_attendees",
        joinColumns = @JoinColumn(name = "eventId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<User> attendees = new ArrayList<>();

    public Events() { }

    public Events(Long eventId, String eventName, String eventType, String eventDate, String location, String description) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.location = location;
        this.description = description;
    }
    public Events(String eventName, String eventType, String eventDate, String location, String description) {
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.location = location;
        this.description = description;
    }   
    
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public String getEventDate() {
        return eventDate;
    }
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public User getCreator() {
        return creator;
    }
    public void setCreator(User creator) {
        this.creator = creator;
    }
}
