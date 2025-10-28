package com.example.CafeQuestBackendAPI.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

@Autowired
private ProviderService providerService;

@GetMapping("/providers")
public Object getAllProviders() {
    return providerService.getAllProviders();
}
@PostMapping("/providers")
public Provider addProvider (@RequestBody Provider provider) {
    return providerService.addProvider(provider);
}
@PutMapping("/providers/{providerId}")
public Provider updateProvider (@PathVariable Long providerId, @RequestBody Provider provider) {
    return providerService.updateProvider(providerId, provider);
}
@DeleteMapping("/providers/{providerId}")
public void deleteProvider (@PathVariable Long providerId) {
    providerService.deleteProvider(providerId);
}

}
