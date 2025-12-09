package com.example.CafeQuestApiApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestApiApplication.entity.CoffeeShop;

@Repository
public interface CoffeeShopRepository extends JpaRepository<CoffeeShop, Long> {
}