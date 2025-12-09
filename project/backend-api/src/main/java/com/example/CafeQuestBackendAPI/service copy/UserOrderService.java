package com.example.CafeQuestApiApplication.service;

import com.example.CafeQuestApiApplication.entity.UserOrder;
import com.example.CafeQuestApiApplication.entity.User;
import com.example.CafeQuestApiApplication.repository.UserOrderRepository;
import com.example.CafeQuestApiApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderService {
    
    @Autowired
    private UserOrderRepository orderRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    // Create new order
    public UserOrder createOrder(Long userId, UserOrder order) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        order.setUser(user);
        return orderRepository.save(order);
    }
    
    // Get all orders for a user
    public List<UserOrder> getOrdersByUserId(Long userId) {
        return orderRepository.findByUser_UserId(userId);
    }
    
    // Get order by ID
    public UserOrder getOrderById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }
    
    // Update order
    public UserOrder updateOrder(Long id, UserOrder orderDetails) {
        UserOrder order = getOrderById(id);
        
        if (orderDetails.getOrderName() != null) {
            order.setOrderName(orderDetails.getOrderName());
        }
        if (orderDetails.getDrinkType() != null) {
            order.setDrinkType(orderDetails.getDrinkType());
        }
        if (orderDetails.getSize() != null) {
            order.setSize(orderDetails.getSize());
        }
        if (orderDetails.getCustomization() != null) {
            order.setCustomization(orderDetails.getCustomization());
        }
        if (orderDetails.getIsFavorite() != null) {
            order.setIsFavorite(orderDetails.getIsFavorite());
        }
        
        return orderRepository.save(order);
    }
    
    // Delete order
    public void deleteOrder(Long id) {
        UserOrder order = getOrderById(id);
        orderRepository.delete(order);
    }
}