package com.example.demo.backend;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    //attribute for saving events associated with user

    public User() {}

    //constructor w/ id
    public User(Long userId, String name, String email, String username, String password, String drink, String major, int gradYear) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.drink = drink;
        this.major = major;
        this.gradYear = gradYear;
    }
    //constructor w/o id
    public User(String name, String email, String username, String password, String drink, String major, int gradYear) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.drink = drink;
        this.major = major;
        this.gradYear = gradYear;
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
}