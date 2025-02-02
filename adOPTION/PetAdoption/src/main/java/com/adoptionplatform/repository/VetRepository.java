package com.adoptionplatform.repository;

import com.adoptionplatform.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
    Vet findByName(String name);  // Μπορούμε να αναζητήσουμε με το όνομα του γιατρού
}
