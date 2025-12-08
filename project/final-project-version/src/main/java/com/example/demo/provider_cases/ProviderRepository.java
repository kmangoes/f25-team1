package com.example.demo.provider_cases;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    
    @Query("SELECT a FROM Provider a WHERE a.name LIKE %?1%")
    List<Provider> getProviderByName(String name);
    
    Provider findByEmail(String email); 
}
