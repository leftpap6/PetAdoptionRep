package com.adoptionplatform.controller;

import com.adoptionplatform.model.Shelter;
import com.adoptionplatform.service.ShelterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShelterController {
    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping("/shelters")
    public String viewShelters(Model model) {
        List<Shelter> shelters = shelterService.getAllShelters();
        model.addAttribute("shelters", shelters);
        return "shelters"; // Refers to shelters.html in templates
    }

    @PostMapping("/shelters/add")
    public String addShelter(@RequestParam String name, @RequestParam String location, @RequestParam int capacity) {
        Shelter shelter = new Shelter();
        shelter.setShelterName(name);
        shelter.setShelterAddress(location);
        shelterService.saveShelter(shelter);
        return "redirect:/shelters";
    }
}
