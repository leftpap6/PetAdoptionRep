package com.adoptionplatform.controller;

import com.adoptionplatform.model.Vet;
import com.adoptionplatform.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping("/vet")
    public String showVetPage(Model model) {
        List<Vet> vets = vetService.getAllVets();
        model.addAttribute("vets", vets);
        return "vet";
    }

    @PostMapping("/vet/add")
    public String addVet(@RequestParam String name, @RequestParam String specialty) {
        Vet newVet = new Vet();
        newVet.setName(name);
        newVet.setSpecialty(specialty);
        vetService.saveVet(newVet);
        return "redirect:/vet";
    }

    @PostMapping("/vet/verifyPetHealth")
    public String verifyPetHealth(@RequestParam Long petId, @RequestParam boolean healthStatus, Model model) {
        String result = vetService.verifyPetHealth(petId, healthStatus);
        model.addAttribute("message", result);
        return "vet"; // Redirects back to the vet page
    }

}
