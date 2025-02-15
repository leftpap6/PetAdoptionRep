package com.adoptionplatform.service;

import com.adoptionplatform.model.User;
import com.adoptionplatform.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional  // Ensures database transactions commit
    public User registerUser(User user) {
        System.out.println("🔹 Step 1: registerUser() called with user: " + user);

        if (userRepository.findByEmail(user.getEmail()) != null) {
            System.out.println("❌ Step 2: Email already exists!");
            throw new IllegalArgumentException("Email is already taken");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("🔹 Step 3: Password encrypted");

        User savedUser = userRepository.save(user);
        System.out.println("✅ Step 4: User saved to database -> " + savedUser);

        return savedUser;
    }

    // Find user by email for login
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public boolean validateLogin(String email, String password) {
        System.out.println("🔹 Checking login for email: " + email);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            System.out.println("❌ User not found: " + email);
            return false;
        }

        System.out.println("🔹 Stored hashed password: " + user.getPassword());
        System.out.println("🔹 Entered password: " + password);

        boolean isPasswordMatch = passwordEncoder.matches(password, user.getPassword());

        if (isPasswordMatch) {
            System.out.println("✅ Password match for: " + email);
        } else {
            System.out.println("❌ Password mismatch for: " + email);
        }

        return isPasswordMatch;
    }

}
