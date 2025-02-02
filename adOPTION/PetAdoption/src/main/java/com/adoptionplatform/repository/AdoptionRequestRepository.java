package com.adoptionplatform.repository;

import com.adoptionplatform.model.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Long> {
    // You can add custom queries here if necessary, for example:
    // List<AdoptionRequest> findByStatus(String status);
}
