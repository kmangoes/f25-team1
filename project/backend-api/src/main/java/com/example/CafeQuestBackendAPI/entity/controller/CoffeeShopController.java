package com.example.CafeQuestBackendAPI.entity.controller;

import com.example.CafeQuestBackendAPI.entity.CoffeeShop;
import com.example.CafeQuestBackendAPI.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffeeshops")
public class CoffeeShopController {
    
    @Autowired
    private CoffeeShopService coffeeShopService;
    
    // Get all coffee shops
    @GetMapping
    public ResponseEntity<List<CoffeeShop>> getAllCoffeeShops() {
        List<CoffeeShop> shops = coffeeShopService.getAllCoffeeShops();
        return ResponseEntity.ok(shops);
    }
    
    // Get coffee shop by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCoffeeShopById(@PathVariable Long id) {
        try {
            CoffeeShop shop = coffeeShopService.getCoffeeShopById(id);
            return ResponseEntity.ok(shop);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    // Create new coffee shop
    @PostMapping
    public ResponseEntity<CoffeeShop> createCoffeeShop(@RequestBody CoffeeShop coffeeShop) {
        CoffeeShop created = coffeeShopService.createCoffeeShop(coffeeShop);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    // Update coffee shop
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCoffeeShop(@PathVariable Long id, @RequestBody CoffeeShop coffeeShop) {
        try {
            CoffeeShop updated = coffeeShopService.updateCoffeeShop(id, coffeeShop);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    // Delete coffee shop
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCoffeeShop(@PathVariable Long id) {
        try {
            coffeeShopService.deleteCoffeeShop(id);
            return ResponseEntity.ok("Coffee shop deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}