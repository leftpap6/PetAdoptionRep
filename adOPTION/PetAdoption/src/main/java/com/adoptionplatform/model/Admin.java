package com.adoptionplatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends User {
    // Αν έχεις επιπλέον πεδία ή λογική για τον Admin μπορείς να τα προσθέσεις εδώ


    public Admin(Long id, String username, String password, String email, String contactNumber, String role) {
        super(id, username, password, email, contactNumber, role);
    }

    public Admin() {

    }
}
