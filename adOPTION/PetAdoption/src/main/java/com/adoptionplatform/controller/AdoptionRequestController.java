package com.adoptionplatform.controller;

import com.adoptionplatform.model.AdoptionRequest;
import com.adoptionplatform.service.AdoptionRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adoption-requests")
public class AdoptionRequestController {

    private final AdoptionRequestService adoptionRequestService;

    public AdoptionRequestController(AdoptionRequestService adoptionRequestService) {
        this.adoptionRequestService = adoptionRequestService;
    }

    @GetMapping
    public List<AdoptionRequest> getAllAdoptionRequests() {
        return adoptionRequestService.getAllAdoptionRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptionRequest> getAdoptionRequestById(@PathVariable long id) {
        Optional<AdoptionRequest> adoptionRequest = adoptionRequestService.getAdoptionRequestById(id);
        return adoptionRequest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdoptionRequest createAdoptionRequest(@RequestBody AdoptionRequest adoptionRequest) {
        return adoptionRequestService.saveAdoptionRequest(adoptionRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdoptionRequest> updateAdoptionRequestStatus(@PathVariable long id, @RequestParam String status) {
        AdoptionRequest updatedRequest = adoptionRequestService.updateAdoptionRequestStatus(id, status);
        return updatedRequest != null ? ResponseEntity.ok(updatedRequest) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdoptionRequest(@PathVariable long id) {
        adoptionRequestService.deleteAdoptionRequest(id);
        return ResponseEntity.noContent().build();
    }
}
