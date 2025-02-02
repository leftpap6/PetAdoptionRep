package com.adoptionplatform.repository;

import com.adoptionplatform.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    // Custom query to find shelters with a pending status
    @Query("SELECT s FROM Shelter s WHERE s.approved = false")
    List<Shelter> findAllPendingShelters();
}
