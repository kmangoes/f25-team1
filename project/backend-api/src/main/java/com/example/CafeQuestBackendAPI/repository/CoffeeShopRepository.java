/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.CafeQuestBackendAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestBackendAPI.entity.CoffeeShop;

@Repository
public interface CoffeeShopRepository extends JpaRepository<CoffeeShop, Long> {
    

}