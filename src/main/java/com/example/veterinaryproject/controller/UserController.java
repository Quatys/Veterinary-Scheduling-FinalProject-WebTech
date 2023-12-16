package com.example.veterinaryproject.controller;

import ch.qos.logback.core.model.Model;
import com.example.veterinaryproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;


    // Registration
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(Model model) {
        return "redirect:/login";
    }

    // Login
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        // Add logic to display login form
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Perform authentication logic here (e.g., check username and password against a database)
        // For simplicity, let's assume a hardcoded username and password
        if ("user".equals(username) && "password".equals(password)) {
            // Authentication successful, redirect to the dashboard
            return "redirect:/dashboard";
        } else {
            // Authentication failed, display an error message
            model.addText( "Invalid username or password");
            return "login";
        }
    }

}
