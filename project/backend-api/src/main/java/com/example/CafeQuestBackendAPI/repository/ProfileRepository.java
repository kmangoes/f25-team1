/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.CafeQuestBackendAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CafeQuestBackendAPI.entity.Profile;

@Repository
public interface ProfileRepository  extends JpaRepository<Profile, Long> {

    @Query("SELECT p FROM Profile p WHERE p.profileId = ?1")
    Optional<Profile> findByUser_UserId(Long userId);
}
