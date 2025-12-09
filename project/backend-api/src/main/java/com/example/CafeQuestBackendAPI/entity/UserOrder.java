package com.example.CafeQuestApiApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_orders")
public class UserOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(nullable = false)
    private String orderName;
    
    @Column(nullable = false)
    private String drinkType;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DrinkSize size;
    
    @Column(columnDefinition = "TEXT")
    private String customization;
    
    @Column(nullable = false)
    private Boolean isFavorite = false;
    
    // Constructors
    public UserOrder() {}
    
    public UserOrder(User user, String orderName, String drinkType, DrinkSize size) {
        this.user = user;
        this.orderName = orderName;
        this.drinkType = drinkType;
        this.size = size;
    }
    
    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getOrderName() {
        return orderName;
    }
    
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    
    public String getDrinkType() {
        return drinkType;
    }
    
    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }
    
    public DrinkSize getSize() {
        return size;
    }
    
    public void setSize(DrinkSize size) {
        this.size = size;
    }
    
    public String getCustomization() {
        return customization;
    }
    
    public void setCustomization(String customization) {
        this.customization = customization;
    }
    
    public Boolean getIsFavorite() {
        return isFavorite;
    }
    
    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
    
    public enum DrinkSize {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }
}