package com.example.demo.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class ProviderController {

@Autowired
private ProviderService providerService;
@Autowired
private RecaptchaService recaptchaService;

@GetMapping("/login")
public String showLoginPage() {
    return "login"; //show login.ftlh
}
@PostMapping("/login") 
public String handleLogin(@RequestParam String email, @RequestParam String password, @RequestParam(name="g-recaptcha-response") String recaptchaResponse, Model model) {
    boolean isValid = providerService.validateLogin(email, password);
    System.out.println("isValid Result: " + isValid);
    System.out.println("Email: " + email);
    System.out.println("Password: " + password);
    
    boolean isRecaptchaValid = recaptchaService.verify(recaptchaResponse);
    System.out.println("isRecaptchaValid Result: " + isRecaptchaValid); //sanity check 
    
    if (!isRecaptchaValid) {
        model.addAttribute("error", "reCAPTCHA verification failed. Please try again.");
        return "login"; // Return to login page with error message
    }
    if (!isValid) {
        model.addAttribute("error", "Invalid email or password");
        return "login"; // Return to login page with error message
    }
    else {
        System.out.println("Login successful for email: " + email);
        return "redirect:/cafes"; // Redirect to provider's cafe dashboard after successful login
    }
}

@GetMapping("/providers")
public Object getAllProviders(Model model) {
    //return providerService.getAllProviders();
    model.addAttribute("providers", providerService.getAllProviders());
    return "providers"; // returns the name of the view (e.g., providers.html)
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