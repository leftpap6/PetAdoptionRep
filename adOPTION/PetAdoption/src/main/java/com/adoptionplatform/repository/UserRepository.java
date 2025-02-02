package com.adoptionplatform.repository;

import com.adoptionplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method to find a user by email
    User findByEmail(String email);
}
