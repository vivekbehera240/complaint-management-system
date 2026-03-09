package com.cms.complaintsystem.controller;

import com.cms.complaintsystem.model.User;
import com.cms.complaintsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Register new user
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        user.setRole("USER");
        userRepository.save(user);

        return "User registered successfully";
    }

    // Login (Admin or User)
    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {

        Optional<User> user = userRepository.findByEmail(loginUser.getEmail());

        if(user.isPresent()) {

            User existingUser = user.get();

            if(existingUser.getPassword().equals(loginUser.getPassword())) {

                if(existingUser.getRole().equals("ADMIN")) {
                    return "Admin Login Success";
                } else {
                    return "User Login Success";
                }

            } else {
                return "Wrong Password";
            }

        }

        return "User not found";
    }
}