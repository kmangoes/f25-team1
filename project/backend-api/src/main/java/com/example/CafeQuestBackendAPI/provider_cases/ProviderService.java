package com.example.CafeQuestBackendAPI.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProviderService {

@Autowired
private ProviderRepository providerRepository;
    
//endpoint mapping methods
public Object getAllProviders() {
    return providerRepository.findAll();
}
public Provider addProvider(Provider provider) {
    return providerRepository.save(provider);
}
public Provider updateProvider(Long providerId, Provider provider) {
    return providerRepository.save(provider);
}
public void deleteProvider(@PathVariable Long providerId) {
    providerRepository.deleteById(providerId);
}


}
