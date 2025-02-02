package com.adoptionplatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdoptionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long adoptionId;
    private long petId;
    private String date;
    private String status;
    private String visitDate;

    // Status constants
    public static final String PENDING = "Pending";
    public static final String VISIT_SCHEDULED = "Visit Scheduled";
    public static final String APPROVED = "Approved";
    public static final String REJECTED = "Rejected";

    public AdoptionRequest() {
        // Default constructor
    }

    public AdoptionRequest(long adoptionId, long petId, String date, String status) {
        this.adoptionId = adoptionId;
        this.petId = petId;
        this.date = date;
        this.status = status;
        this.visitDate = null;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAdoptionId() {
        return adoptionId;
    }

    public void setAdoptionId(long adoptionId) {
        this.adoptionId = adoptionId;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return "AdoptionRequest{" +
                "id=" + id +
                ", adoptionId=" + adoptionId +
                ", petId=" + petId +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", visitDate='" + visitDate + '\'' +
                '}';
    }
}
