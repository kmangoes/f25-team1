package com.example.CafeQuestBackendAPI.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProviderService {

@Autowired
private ProviderRepository providerRepository;
    
//endpoint mapping methods
public Provider addProvider(Provider provider) {
    return providerRepository.save(provider);
}
public Provider updateProvider(Provider providerId, Provider provider) {
    return providerRepository.save(provider);
}



}
