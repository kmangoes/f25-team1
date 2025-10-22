package com.example.CafeQuestBackendAPI.provider_cases;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("SELECT a FROM Service a WHERE a.serviceName LIKE %?1%")
    List<Service> getServiceByName(String serviceName);
    
}
