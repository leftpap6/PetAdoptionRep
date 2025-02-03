package com.adoptionplatform.controller;

import com.adoptionplatform.model.Pet;
import com.adoptionplatform.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // Display all pets
    @GetMapping
    public String getAllPets(Model model) {
        List<Pet> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        return "pets"; // Thymeleaf template name (pets.html)
    }

    // Display a single pet by ID
    @GetMapping("/{id}")
    public String getPetById(@PathVariable Long id, Model model) {
        Optional<Pet> pet = petService.getPetById(id);
        if (pet.isPresent()) {
            model.addAttribute("pet", pet.get());
            return "pet-details"; // Thymeleaf template for a single pet
        }
        return "redirect:/pets";
    }

    // Show form to add a new pet
    @GetMapping("/new")
    public String showPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "pet-form"; // Thymeleaf template for adding a pet
    }

    // Save a new pet
    @PostMapping("/save")
    public String createPet(@ModelAttribute Pet pet) {
        petService.savePet(pet);
        return "redirect:/pets";
    }

    // Delete a pet
    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/pets";
    }
}
