package com.example.demo.backend;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;
    @Column(name="email", nullable = false)
    private String email;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column
    private String drink; //optional field for user's favorite cafe drink
    @Column 
    private String major; 
    @Column
    private int gradYear; 

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Review> reviews = new ArrayList<>();
    
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Events> createdEvents = new ArrayList<>();
    @ManyToMany(mappedBy = "attendees")
    private List<Events> attendingEvents = new ArrayList<>();


    //attribute for saving events associated with user

    public User() {}

    //constructor w/ id
    public User(Long userId, String name, String email, String username, String password, String drink, String major, int gradYear, List<Review> reviews, List<Events> createdEvents, List<Events> attendingEvents) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.drink = drink;
        this.major = major;
        this.gradYear = gradYear;
        this.reviews = reviews;
        this.createdEvents = new ArrayList<>();
        this.attendingEvents = new ArrayList<>();
    }
    //constructor w/o id
    public User(String name, String email, String username, String password, String drink, String major, int gradYear, List<Review> reviews, List<Events> createdEvents, List<Events> attendingEvents) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.drink = drink;
        this.major = major;
        this.gradYear = gradYear;
        this.reviews = reviews;
        this.createdEvents = new ArrayList<>();
        this.attendingEvents = new ArrayList<>();
    }

    //getters and setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDrink() {
        return drink;
    }
    public void setDrink(String drink) {
        this.drink = drink;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public int getGradYear() {
        return gradYear;
    }
    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public List<Events> getCreatedEvents() {
        return createdEvents;
    }
    public void setCreatedEvents(List<Events> createdEvents) {
        this.createdEvents = createdEvents;
    }
    public List<Events> getAttendingEvents() {
        return attendingEvents;
    }
    public void setAttendingEvents(List<Events> attendingEvents) {
        this.attendingEvents = attendingEvents;
    }
}