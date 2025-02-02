package com.adoptionplatform.controller;

import com.adoptionplatform.model.Pet;
import com.adoptionplatform.model.Shelter;
import com.adoptionplatform.model.User;
import com.adoptionplatform.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Approve Pets
    @GetMapping("/approve/pet")
    public ResponseEntity<?> getPendingPets() {
        return adminService.getPendingPets();
    }

    @PostMapping("/approve/pet/{petId}")
    public ResponseEntity<String> approvePet(@PathVariable long petId) {
        return adminService.approvePet(petId);
    }

    // Approve Shelters
    @GetMapping("/approve/shelter")
    public ResponseEntity<?> getPendingShelters() {
        return adminService.getPendingShelters();
    }

    @PostMapping("/approve/shelter/{shelterId}")
    public ResponseEntity<String> approveShelter(@PathVariable long shelterId) {
        return adminService.approveShelter(shelterId);
    }

    // View Reports
    @GetMapping("/view/reports")
    public ResponseEntity<?> viewReports() {
        return adminService.viewReports();
    }

    // Manage Users
    @GetMapping("/manage/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return adminService.getAllUsers();
    }

    @DeleteMapping("/manage/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {
        return adminService.deleteUser(userId);
    }
}
