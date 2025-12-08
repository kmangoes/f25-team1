package com.example.demo.provider_cases;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CafesRepository extends JpaRepository<Cafes, Long>{
    
    @Query("SELECT a FROM Cafes a WHERE a.cafeName LIKE %?1%")
    List<Cafes> getCafeByName(String cafeName);

}
