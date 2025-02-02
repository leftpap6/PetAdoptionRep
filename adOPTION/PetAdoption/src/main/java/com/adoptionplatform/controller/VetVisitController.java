package com.adoptionplatform.controller;

import com.adoptionplatform.model.VetVisit;
import com.adoptionplatform.service.VetVisitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vet-visits")
public class VetVisitController {

    private final VetVisitService vetVisitService;

    public VetVisitController(VetVisitService vetVisitService) {
        this.vetVisitService = vetVisitService;
    }

    @GetMapping
    public List<VetVisit> getAllVetVisits() {
        return vetVisitService.getAllVetVisits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VetVisit> getVetVisitById(@PathVariable long id) {
        Optional<VetVisit> vetVisit = vetVisitService.getVetVisitById(id);
        return vetVisit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public VetVisit createVetVisit(@RequestBody VetVisit vetVisit) {
        return vetVisitService.saveVetVisit(vetVisit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVetVisit(@PathVariable long id) {
        vetVisitService.deleteVetVisit(id);
        return ResponseEntity.noContent().build();
    }
}
