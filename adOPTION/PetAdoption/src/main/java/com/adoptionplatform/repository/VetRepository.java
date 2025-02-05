package com.adoptionplatform.repository;

import com.adoptionplatform.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VetRepository extends JpaRepository<Vet, Long> {
    Vet findByName(String name);  // Μπορούμε να αναζητήσουμε με το όνομα του γιατρού
}
