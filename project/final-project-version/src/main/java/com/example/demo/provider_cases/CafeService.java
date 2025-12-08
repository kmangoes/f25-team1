package com.example.demo.provider_cases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class CafeService {
    
@Autowired
private CafesRepository cafesRepository;

//endpoint mapping
public Object getAllCafes() {
    return cafesRepository.findAll();
}
public Cafes getCafeById(@PathVariable Long cafeId) {
    return cafesRepository.findById(cafeId).orElse(null);
}
public Object getCafeByName(String cafeName){
    return cafesRepository.getCafeByName(cafeName);
}
public Cafes addCafe(Cafes cafe){
    return cafesRepository.save(cafe);
}
public void deleteCafe (Long cafeId) {
    cafesRepository.deleteById(cafeId);
}
public Cafes updateCafe(Long cafeId, Cafes updatedCafe) {
    return cafesRepository.save(updatedCafe);
}

}
