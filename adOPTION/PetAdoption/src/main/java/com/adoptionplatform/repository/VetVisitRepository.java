package com.adoptionplatform.repository;

import com.adoptionplatform.model.VetVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetVisitRepository extends JpaRepository<VetVisit, Long> {
    // Custom queries can be added here if necessary
}
