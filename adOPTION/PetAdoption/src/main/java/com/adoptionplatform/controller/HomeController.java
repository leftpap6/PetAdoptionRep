package com.adoptionplatform.controller;

import com.adoptionplatform.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    // Display the home page with the menu options
    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("message", "=== Pet Adoption System ===");
        return "index";  // Display the home.html view
    }

    // Handle registration form display
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "register"; // Return registration page
    }

    // Handle login form display
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login"; // Return login page
    }

    // Handle registration process
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestParam String username, @RequestParam String password,
                               @RequestParam String email, @RequestParam String contactNumber,
                               @RequestParam String role, Model model) {
        // Implement registration logic here (similar to your original code)
        // Add user to the system

        model.addAttribute("message", "Sign up successful!");
        return "index";  // Redirect back to the home page
    }

    // Handle login process
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        // Implement login logic here (similar to your original code)
        // Check if user credentials are correct

        model.addAttribute("message", "Welcome, " + email + "!");
        return "index";  // Redirect back to the home page
    }
}
