package com.example.demo.provider_cases;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList; 
import java.util.List; 

@Entity
@Table(name = "cafes")
public class Cafes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafeId")
    private Long cafeId;

    @Column(nullable = false)
    private String cafeName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double rating;
    @Column(nullable = false) 
    private String hours; 

    /* Each cafe gets its own reviews table */
    @OneToMany(mappedBy = "cafe", cascade=CascadeType.ALL)
    private List<Reviews> reviews = new ArrayList<>();


    public Cafes() {} //empty constructor

    /* constructor w/ cafeId */
    public Cafes (Long cafeId, String cafeName, String address, String description, double rating, String hours, List<Reviews> reviews) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.address = address;
        this.description = description;
        this.rating = rating; 
        this.hours = hours;
        this.reviews = reviews;
    }

    /* constructor without cafeId */
    public Cafes (String cafeName, String address, String description, double rating, String hours, List<Reviews> reviews) {
        this.cafeName = cafeName;
        this.address = address;
        this.description = description;
        this.rating = rating; 
        this.hours = hours;
        this.reviews = reviews; 
    }

    public Long getCafeId() {
        return cafeId;
    }
    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }
    public String getCafeName() {
        return cafeName;
    }
    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress (String address) {
        this.address = address;
    }
    public String getDescription() {
        return description; 
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public List<Reviews> getReviews() {
        return reviews; 
    }
    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }
    public String getHours() {
        return hours; 
    }
    public void setHours(String hours) {
        this.hours = hours; 
    }
}
