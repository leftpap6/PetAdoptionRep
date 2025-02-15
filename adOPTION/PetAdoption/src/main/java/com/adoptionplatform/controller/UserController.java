package com.adoptionplatform.controller;

import com.adoptionplatform.model.User;
import com.adoptionplatform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // Register a new user
//    @PostMapping("/register")
//    public ResponseEntity<User> register(@Valid @ModelAttribute User user) {
//        User newUser = userService.registerUser(user);
//        return ResponseEntity.ok(newUser);
//    }

    @PostMapping("/test")
    public ResponseEntity<String> testPost() {
        System.out.println("✅ Received a POST request at /test!");
        return ResponseEntity.ok("POST request is working!");
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        System.out.println("🔹 API called: /api/users/register with user: " + user);
        userService.registerUser(user);
        System.out.println("✅ User registration complete!");
        return ResponseEntity.ok("User registered successfully!");
    }


//     Log in a user (authentication)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        System.out.println("🔹 Login attempt for email: " + email);

        boolean validLogin = userService.validateLogin(email, password);
        if (validLogin) {
            System.out.println("✅ Login successful for email: " + email);
            return ResponseEntity.ok("Login successful!");
        } else {
            System.out.println("❌ Invalid login for email: " + email);
            return ResponseEntity.status(401).body("Invalid email or password.");
        }
    }
}
