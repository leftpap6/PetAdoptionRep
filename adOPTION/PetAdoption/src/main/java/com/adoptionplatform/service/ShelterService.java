package com.adoptionplatform.service;

import com.adoptionplatform.model.AdoptionRequest;
import com.adoptionplatform.model.Pet;
import com.adoptionplatform.model.VetVisit;
import com.adoptionplatform.repository.AdoptionRequestRepository;
import com.adoptionplatform.repository.PetRepository;
import com.adoptionplatform.repository.VetVisitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShelterService {
    private final AdoptionRequestRepository adoptionRequestRepository;
    private final PetRepository petRepository;

    public ShelterService(AdoptionRequestRepository adoptionRequestRepository, PetRepository petRepository) {
        this.adoptionRequestRepository = adoptionRequestRepository;
        this.petRepository = petRepository;
    }

    public List<AdoptionRequest> viewAdoptionRequest() {
        return adoptionRequestRepository.findAll();
    }

    public Pet addPet(String name, int age, String species, String breed, String healthStatus, String adoptionStatus, long shelterId) {
        Pet newPet = new Pet();
        newPet.setName(name);
        newPet.setAge(age);
        newPet.setSpecies(species);
        newPet.setBreed(breed);
        newPet.setHealthChecked(false);
        newPet.setApproved(false);
        return petRepository.save(newPet);
    }

    public String communicateWithAdopter(String email, String message) {
        return "Email sent to " + email + " with message: " + message;
    }
}