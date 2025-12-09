package com.example.demo.backend;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT a FROM User a WHERE a.name LIKE %?1%")
    List<User> getUserByName(String name);

    Optional<User> findByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findUsersByUsername(String username);
}
