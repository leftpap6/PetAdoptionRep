package com.adoptionplatform.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long petId;
    private String name;
    private String species;
    private String breed;
    private int age;
    private boolean healthChecked;
    private boolean approved;// Approval status
    private String image;

//    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Pet> pets = new ArrayList<>();



    // Getters and Setters

    public Pet(long petId, String name, String species, String breed, int age, boolean healthChecked, boolean approved,String image ) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.healthChecked = healthChecked;
        this.approved = approved;
        this.image = image;
    }

    public Pet() {

    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHealthChecked() {
        return healthChecked;
    }

    public void setHealthChecked(boolean healthChecked) {
        this.healthChecked = healthChecked;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}
}
