package com.example.CafeQuestApiApplication.service;

import com.example.CafeQuestApiApplication.entity.CoffeeShop;
import com.example.CafeQuestApiApplication.repository.CoffeeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeShopService {
    
    @Autowired
    private CoffeeShopRepository coffeeShopRepository;
    
    // Get all coffee shops
    public List<CoffeeShop> getAllCoffeeShops() {
        return coffeeShopRepository.findAll();
    }
    
    // Get coffee shop by ID
    public CoffeeShop getCoffeeShopById(Long id) {
        return coffeeShopRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Coffee shop not found"));
    }
    
    // Create new coffee shop
    public CoffeeShop createCoffeeShop(CoffeeShop coffeeShop) {
        return coffeeShopRepository.save(coffeeShop);
    }
    
    // Update coffee shop
    public CoffeeShop updateCoffeeShop(Long id, CoffeeShop shopDetails) {
        CoffeeShop shop = getCoffeeShopById(id);
        
        if (shopDetails.getName() != null) {
            shop.setName(shopDetails.getName());
        }
        if (shopDetails.getAddress() != null) {
            shop.setAddress(shopDetails.getAddress());
        }
        if (shopDetails.getPhone() != null) {
            shop.setPhone(shopDetails.getPhone());
        }
        if (shopDetails.getWebsite() != null) {
            shop.setWebsite(shopDetails.getWebsite());
        }
        if (shopDetails.getDescription() != null) {
            shop.setDescription(shopDetails.getDescription());
        }
        if (shopDetails.getLatitude() != null) {
            shop.setLatitude(shopDetails.getLatitude());
        }
        if (shopDetails.getLongitude() != null) {
            shop.setLongitude(shopDetails.getLongitude());
        }
        
        return coffeeShopRepository.save(shop);
    }
    
    // Delete coffee shop
    public void deleteCoffeeShop(Long id) {
        CoffeeShop shop = getCoffeeShopById(id);
        coffeeShopRepository.delete(shop);
    }
}