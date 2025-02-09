package com.adoptionplatform.controller;

import com.adoptionplatform.model.Pet;
import com.adoptionplatform.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/pets") // Class-level mapping
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    // Display all pets
//    @GetMapping // Maps to /pets
//    public String getAllPets(Model model) {
//        List<Pet> pets = petService.getAllPets();
//        model.addAttribute("pets", pets);
//        return "pets"; // Thymeleaf template name (pets.html)
//    }

    // Display a single pet by ID
    @GetMapping("/{id}") // Maps to /pets/{id}
    public String getPetById(@PathVariable Long id, Model model) {
        Optional<Pet> pet = petService.getPetById(id);
        if (pet.isPresent()) {
            model.addAttribute("pet", pet.get());
            return "pet-details"; // Thymeleaf template for a single pet
        }
        return "redirect:/pets";
    }

     //Show form to add a new pet
    @GetMapping // Maps to /pets/new
    public String showPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "pets"; // Thymeleaf template for adding a pet
    }

    // Save a new pet
    @PostMapping // Maps to /pets
    public String addPet(@ModelAttribute Pet pet, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
            File destinationFile = new File(UPLOAD_DIR + fileName);
            imageFile.transferTo(destinationFile);
            pet.setImage("/images/" + fileName);
        }

        petService.savePet(pet);
        return "redirect:/pets";
    }

    // Delete a pet
    @GetMapping("/delete/{id}") // Maps to /pets/delete/{id}
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/pets";
    }
}