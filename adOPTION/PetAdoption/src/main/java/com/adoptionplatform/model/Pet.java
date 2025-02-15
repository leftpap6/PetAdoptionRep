package com.adoptionplatform.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long petId;
    private String name;
    private String species;
    private String breed;
    private int age;
    private boolean healthChecked;
    private boolean approved; // Approval status


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "pet_shelter",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "shelter_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"pet_id", "shelter_id"})
    )
    private List<Shelter> shelters = new ArrayList<>();

    public Pet() {}

    public Pet(long petId, String name, String species, String breed, int age, boolean healthChecked, boolean approved) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.healthChecked = healthChecked;
        this.approved = approved;
    }

    // Getters and Setters

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


    public List<Shelter> getShelters() {
        return shelters;
    }

    public void setShelters(List<Shelter> shelters) {
        this.shelters = shelters;
    }
}
