package com.example.CafeQuestBackendAPI.provider_cases;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Service entity class
 */
@Entity
@Table(name="service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column (nullable = false)
    private String serviceName;
    @Column (nullable = false)
    private String serviceType;
    @Column (nullable = false)
    private String date;
    @Column (nullable = false)
    private String location;
    @Column 
    private String description;

    public Service() { }

    public Service(Long serviceId, String serviceName, String serviceType, String date, String location, String description) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.date = date;
        this.location = location;
        this.description = description;
    }
    public Service(String serviceName, String serviceType, String date, String location, String description) {
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.date = date;
        this.location = location;
        this.description = description;
    }    
    
    public Long getServiceId() {
        return serviceId;
    }
    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
