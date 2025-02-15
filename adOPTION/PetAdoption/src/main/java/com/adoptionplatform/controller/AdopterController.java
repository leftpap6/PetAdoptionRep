package com.adoptionplatform.controller;

import com.adoptionplatform.model.AdoptionRequest;
import com.adoptionplatform.model.Pet;
import com.adoptionplatform.service.AdopterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdopterController {
    private final AdopterService adopterService;

    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping("/adopter")
    public String viewAvailablePets(Model model) {
        List<Pet> pets = adopterService.viewAvailablePets();
        model.addAttribute("pets", pets);
        return "adopter";
    }

    @PostMapping("/adopter/apply")
    public String applyForAdoption(@RequestParam Long adopterId, @RequestParam Long petId, Model model) {
        AdoptionRequest request = adopterService.applyForAdoption(adopterId, petId);
        model.addAttribute("message", "Adoption request submitted successfully!");
        return "redirect:/adopter";
    }

    @PostMapping("/adopter/schedule-visit")
    public String scheduleVisit(@RequestParam Long adoptionRequestId, @RequestParam String visitDate, Model model) {
        String response = adopterService.scheduleVisit(adoptionRequestId, visitDate);
        model.addAttribute("message", response);
        return "redirect:/adopter";
    }
}
