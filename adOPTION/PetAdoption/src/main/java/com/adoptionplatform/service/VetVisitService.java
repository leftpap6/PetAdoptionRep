package com.adoptionplatform.service;

import com.adoptionplatform.model.VetVisit;
import com.adoptionplatform.repository.VetVisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VetVisitService {

    private final VetVisitRepository vetVisitRepository;

    public VetVisitService(VetVisitRepository vetVisitRepository) {
        this.vetVisitRepository = vetVisitRepository;
    }

    // Save a vet visit
    public VetVisit saveVetVisit(VetVisit vetVisit) {
        return vetVisitRepository.save(vetVisit);
    }

    // Get all vet visits
    public List<VetVisit> getAllVetVisits() {
        return vetVisitRepository.findAll();
    }

    // Get vet visit by ID
    public Optional<VetVisit> getVetVisitById(long id) {
        return vetVisitRepository.findById(id);
    }

    // Delete a vet visit by ID
    public void deleteVetVisit(long id) {
        vetVisitRepository.deleteById(id);
    }
}
