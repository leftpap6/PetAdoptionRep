package com.adoptionplatform.controller;

import com.adoptionplatform.model.Pet;
import com.adoptionplatform.repository.PetRepository;
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
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    @Autowired
    private PetRepository petRepository;
    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

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

    @PostMapping("/add")
    public String addPet(@RequestParam("name") String name,
                         @RequestParam("age") int age,
                         @RequestParam("species") String species,
                         @RequestParam("breed") String breed,
                         @RequestParam("healthStatus") String healthStatus,
                         @RequestParam("adoptionStatus") String adoptionStatus,
                         @RequestParam("image") MultipartFile imageFile) throws IOException {

        String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        File destinationFile = new File(UPLOAD_DIR + fileName);
        imageFile.transferTo(destinationFile);

        Pet pet = new Pet();
        pet.setName(name);
        pet.setAge(age);
        pet.setSpecies(species);
        pet.setBreed(breed);
        pet.setHealthChecked(healthStatus.equalsIgnoreCase("healthy"));
        pet.setApproved(adoptionStatus.equalsIgnoreCase("available"));
        pet.setImage("/images/" + fileName);

        petRepository.save(pet);
        return "redirect:/pets";
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
