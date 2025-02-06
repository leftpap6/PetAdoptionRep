package com.adoptionplatform.service;

import com.adoptionplatform.model.Pet;
import com.adoptionplatform.model.Shelter;
import com.adoptionplatform.model.User;
import com.adoptionplatform.repository.PetRepository;
import com.adoptionplatform.repository.ShelterRepository;
import com.adoptionplatform.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final PetRepository petRepository;
    private final ShelterRepository shelterRepository;
    private final UserRepository userRepository;

    public AdminService(PetRepository petRepository, ShelterRepository shelterRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.shelterRepository = shelterRepository;
        this.userRepository = userRepository;
    }


    // Get Pending Pets
    public ResponseEntity<?> getPendingPets() {
        List<Pet> pendingPets = petRepository.findAllPendingPets();
        if (pendingPets.isEmpty()) {
            return ResponseEntity.status(404).body("No pending pets to approve.");
        }
        return ResponseEntity.ok(pendingPets);
    }

    // Approve Pet
    public ResponseEntity<String> approvePet(long petId) {
        Optional<Pet> petOpt = petRepository.findById(petId);
        if (petOpt.isPresent()) {
            Pet pet = petOpt.get();
            pet.setApproved(true);  // Assuming 'approved' field in Pet entity
            petRepository.save(pet);
            return ResponseEntity.ok("Pet approved for adoption: " + pet.getName());
        } else {
            return ResponseEntity.status(404).body("Pet not found.");
        }
    }

    // Get Pending Shelters
    public ResponseEntity<?> getPendingShelters() {
        List<Shelter> pendingShelters = shelterRepository.findAllPendingShelters();
        if (pendingShelters.isEmpty()) {
            return ResponseEntity.status(404).body("No pending shelters.css to approve.");
        }
        return ResponseEntity.ok(pendingShelters);
    }

    // Approve Shelter
    public ResponseEntity<String> approveShelter(long shelterId) {
        Optional<Shelter> shelterOpt = shelterRepository.findById(shelterId);
        if (shelterOpt.isPresent()) {
            Shelter shelter = shelterOpt.get();
            shelter.setApproved(true);  // Assuming 'approved' field in Shelter entity
            shelterRepository.save(shelter);
            return ResponseEntity.ok("Shelter approved: " + shelter.getShelterName());
        } else {
            return ResponseEntity.status(404).body("Shelter not found.");
        }
    }

    // View Reports
    public ResponseEntity<?> viewReports() {
        long totalPets = petRepository.count();
        long totalShelters = shelterRepository.count();
        return ResponseEntity.ok("Total Pets: " + totalPets + ", Total Shelters: " + totalShelters);
    }

    // Get All Users
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    // Delete User
    public ResponseEntity<String> deleteUser(long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            userRepository.delete(userOpt.get());
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("User not found.");
        }
    }
}
