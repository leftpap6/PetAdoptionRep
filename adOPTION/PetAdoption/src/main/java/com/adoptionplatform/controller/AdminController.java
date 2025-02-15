package com.adoptionplatform.controller;

import com.adoptionplatform.model.Pet;
import com.adoptionplatform.model.Shelter;
import com.adoptionplatform.model.User;
import com.adoptionplatform.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Admin Dashboard
    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("pendingPets", adminService.getPendingPets().getBody());
        model.addAttribute("pendingShelters", adminService.getPendingShelters().getBody());
        model.addAttribute("users", adminService.getAllUsers().getBody());
        model.addAttribute("reports", adminService.viewReports().getBody());
        return "admin-dashboard"; // Thymeleaf template
    }

    // Approve Pet
    @PostMapping("/approve/pet/{petId}")
    public String approvePet(@PathVariable long petId) {
        adminService.approvePet(petId);
        return "redirect:/admin/dashboard";
    }

    // Approve Shelter
    @PostMapping("/approve/shelter/{shelterId}")
    public String approveShelter(@PathVariable long shelterId) {
        adminService.approveShelter(shelterId);
        return "redirect:/admin/dashboard";
    }

    // Delete User
    @PostMapping("/delete/user/{userId}")
    public String deleteUser(@PathVariable long userId) {
        adminService.deleteUser(userId);
        return "redirect:/admin/dashboard";
    }
}
