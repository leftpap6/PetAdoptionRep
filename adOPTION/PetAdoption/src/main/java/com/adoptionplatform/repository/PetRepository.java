package com.adoptionplatform.repository;
import com.adoptionplatform.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    // Custom query to find pending pets
    @Query("SELECT p FROM Pet p WHERE p.approved = false ")
    List<Pet> findAllPendingPets();
}
