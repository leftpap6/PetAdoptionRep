package com.adoptionplatform.controller;

import com.adoptionplatform.model.Vet;
import com.adoptionplatform.model.VetVisit;
import com.adoptionplatform.service.VetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vets")
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @PostMapping("/visit")
    public ResponseEntity<VetVisit> visitPet(@RequestParam Long vetId, @RequestParam Long petId, @RequestParam Date visitDate, @RequestParam String notes) {
        return ResponseEntity.ok(vetService.visitPet(vetId, petId, visitDate, notes));
    }

    @PutMapping("/verify-health/{petId}")
    public ResponseEntity<String> verifyPetHealth(@PathVariable Long petId, @RequestParam boolean healthChecked) {
        return ResponseEntity.ok(vetService.verifyPetHealth(petId, healthChecked));
    }
}

