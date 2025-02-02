package com.adoptionplatform.service;

import com.adoptionplatform.model.AdoptionRequest;
import com.adoptionplatform.repository.AdoptionRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdoptionRequestService {

    private final AdoptionRequestRepository adoptionRequestRepository;

    public AdoptionRequestService(AdoptionRequestRepository adoptionRequestRepository) {
        this.adoptionRequestRepository = adoptionRequestRepository;
    }

    // Create or update an adoption request
    public AdoptionRequest saveAdoptionRequest(AdoptionRequest adoptionRequest) {
        return adoptionRequestRepository.save(adoptionRequest);
    }

    // Get all adoption requests
    public List<AdoptionRequest> getAllAdoptionRequests() {
        return adoptionRequestRepository.findAll();
    }

    // Get adoption request by ID
    public Optional<AdoptionRequest> getAdoptionRequestById(long id) {
        return adoptionRequestRepository.findById(id);
    }

    // Delete an adoption request by ID
    public void deleteAdoptionRequest(long id) {
        adoptionRequestRepository.deleteById(id);
    }

    // Update status of adoption request
    public AdoptionRequest updateAdoptionRequestStatus(long id, String status) {
        Optional<AdoptionRequest> adoptionRequest = adoptionRequestRepository.findById(id);
        if (adoptionRequest.isPresent()) {
            AdoptionRequest request = adoptionRequest.get();
            request.setStatus(status);
            return adoptionRequestRepository.save(request);
        }
        return null;
    }
}
