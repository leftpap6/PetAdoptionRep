package com.adoptionplatform.service;

import com.adoptionplatform.model.Pet;
import com.adoptionplatform.model.Vet;
import com.adoptionplatform.model.VetVisit;
import com.adoptionplatform.repository.PetRepository;
import com.adoptionplatform.repository.VetRepository;
import com.adoptionplatform.repository.VetVisitRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VetService {
    private final PetRepository petRepository;
    private final VetVisitRepository vetVisitRepository;

    public VetService(PetRepository petRepository, VetVisitRepository vetVisitRepository) {
        this.petRepository = petRepository;
        this.vetVisitRepository = vetVisitRepository;
    }

    public VetVisit visitPet(Long vetId, Long petId, Date visitDate, String notes) {
        VetVisit vetVisit = new VetVisit();
        vetVisit.setVetId(vetId);
        vetVisit.setPetId(petId);
        vetVisit.setVisitDate(visitDate);
        vetVisit.setNotes(notes);
        return vetVisitRepository.save(vetVisit);
    }

    public String verifyPetHealth(Long petId, Boolean healthStatus) {
        Pet pet = petRepository.findById(petId).orElse(null);
        if (pet != null) {
            pet.setHealthChecked(healthStatus);
            petRepository.save(pet);
            return "Pet health verified: " + healthStatus;
        }
        return "Pet not found.";
    }
}

