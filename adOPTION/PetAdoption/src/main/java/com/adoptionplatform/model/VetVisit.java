package com.adoptionplatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class VetVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date visitDate;
    private String notes;
    private long petId;
    private long vetId;

    public VetVisit() {
        // Default constructor
    }

    public VetVisit(Date visitDate, String notes, long petId, long vetId) {
        this.visitDate = visitDate;
        this.notes = notes;
        this.petId = petId;
        this.vetId = vetId;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public long getVetId() {
        return vetId;
    }

    public void setVetId(long vetId) {
        this.vetId = vetId;
    }

    @Override
    public String toString() {
        return "VetVisit{" +
                "id=" + id +
                ", visitDate=" + visitDate +
                ", notes='" + notes + '\'' +
                ", petId=" + petId +
                ", vetId=" + vetId +
                '}';
    }
}
