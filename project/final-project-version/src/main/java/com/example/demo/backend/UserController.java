package com.example.demo.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class UserController {

@Autowired
private UserService userService;
@Autowired
private RecaptchaService recaptchaService;

//show login page
@GetMapping("/users/login")
public String showLoginPage() {
    return "user_login"; //shows user_login.ftlh
    }
//handle USER login
@PostMapping("/users/login")
public String handleLogin(@RequestParam String email, @RequestParam String password, @RequestParam(name="g-recaptcha-response") String recaptchaResponse, Model model) {
    boolean isValid = userService.validateLogin(email, password);
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
        return "redirect:/cafes"; // Redirect to user's cafe dashboard after successful login
        }
    }
@PostMapping("/users/{userId}")
public User updateUser (@PathVariable Long userId, @RequestBody User updatedUser) {
    return userService.updateUser(userId, updatedUser);
}
@PostMapping("/users/delete/{userId}")
public void deleteUser (@PathVariable Long userId) {
    userService.deleteUser(userId);
}
@GetMapping("/users/signupForm")
public String showUserSignupForm() {
    return "user_signup"; //shows user_signup.ftlh
}
@PostMapping("/users")
public Object addUser (User user) {
    userService.addUser(user);
    return "redirect:/users/login"; //redirects to user login page after signup
}

}