package com.example.demo.backend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

@Autowired 
private UserRepository userRepository;

//endpoint mapping methods
public Object getAllUsers() {
    return userRepository.findAll();
    }
public User addUser(User user) {
    return userRepository.save(user);
    }
public User updateUser(Long userId, User user) {
    return userRepository.save(user);
    }
public void deleteUser(@PathVariable Long userId) {
    userRepository.deleteById(userId);
    }
public boolean validateLogin(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            return false; // email not found
        }

        return user.getPassword().equals(password);
}
public User getByUsername(String username) {
    return userRepository.findUsersByUsername(username);
}
public User getByEmail(String email) {
    return userRepository.findByEmail(email).orElse(null);
}

}
