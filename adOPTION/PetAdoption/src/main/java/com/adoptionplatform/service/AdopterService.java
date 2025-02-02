package com.adoptionplatform.service;

import com.adoptionplatform.model.Adopter;
import com.adoptionplatform.model.AdoptionRequest;
import com.adoptionplatform.model.Pet;
import com.adoptionplatform.repository.AdopterRepository;
import com.adoptionplatform.repository.AdoptionRequestRepository;
import com.adoptionplatform.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdopterService {
    private final PetRepository petRepository;
    private final AdoptionRequestRepository adoptionRequestRepository;

    public AdopterService(PetRepository petRepository, AdoptionRequestRepository adoptionRequestRepository) {
        this.petRepository = petRepository;
        this.adoptionRequestRepository = adoptionRequestRepository;
    }

    public List<Pet> viewAvailablePets() {
        return petRepository.findAll();
    }   

    public AdoptionRequest applyForAdoption(Long adopterId, Long petId) {
        AdoptionRequest request = new AdoptionRequest();
        request.setAdoptionId(adopterId);
        request.setPetId(petId);
        request.setStatus("Pending");
        return adoptionRequestRepository.save(request);
    }

    public String scheduleVisit(Long adoptionRequestId, String visitDate) {
        AdoptionRequest request = adoptionRequestRepository.findById(adoptionRequestId).orElse(null);
        if (request != null) {
            request.setVisitDate(visitDate);
            adoptionRequestRepository.save(request);
            return "Visit scheduled for " + visitDate;
        }
        return "Adoption request not found.";
    }
}
