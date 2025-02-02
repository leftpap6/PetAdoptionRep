package com.adoptionplatform.controller;

import com.adoptionplatform.model.AdoptionRequest;
import com.adoptionplatform.model.Pet;
import com.adoptionplatform.service.ShelterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/shelters")
public class ShelterController {
    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping("/adoption-requests")
    public ResponseEntity<List<AdoptionRequest>> viewAdoptionRequest() {
        return ResponseEntity.ok(shelterService.viewAdoptionRequest());
    }

    @PostMapping("/add-pet")
    public ResponseEntity<Pet> addPet(@RequestParam String name, @RequestParam int age, @RequestParam String species, @RequestParam String breed, @RequestParam String healthStatus, @RequestParam String adoptionStatus, @RequestParam long shelterId) {
        return ResponseEntity.ok(shelterService.addPet(name, age, species, breed, healthStatus, adoptionStatus, shelterId));
    }

    @PostMapping("/communicate")
    public ResponseEntity<String> communicateWithAdopter(@RequestParam String email, @RequestParam String message) {
        return ResponseEntity.ok(shelterService.communicateWithAdopter(email, message));
    }
}
