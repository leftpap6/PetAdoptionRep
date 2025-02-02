package com.adoptionplatform.controller;

import com.adoptionplatform.model.Adopter;
import com.adoptionplatform.model.AdoptionRequest;
import com.adoptionplatform.model.Pet;
import com.adoptionplatform.service.AdopterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adopters")
public class AdopterController {
    private final AdopterService adopterService;

    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> viewAvailablePets() {
        return ResponseEntity.ok(adopterService.viewAvailablePets());
    }

    @PostMapping("/apply")
    public ResponseEntity<AdoptionRequest> applyForAdoption(@RequestParam Long adopterId, @RequestParam Long petId) {
        return ResponseEntity.ok(adopterService.applyForAdoption(adopterId, petId));
    }

    @PutMapping("/schedule-visit")
    public ResponseEntity<String> scheduleVisit(@RequestParam Long adoptionRequestId, @RequestParam String visitDate) {
        return ResponseEntity.ok(adopterService.scheduleVisit(adoptionRequestId, visitDate));
    }
}

