package com.example.veterinaryproject.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private String ownerName;
    private Date appointmentDate;
    private String appointmentTime;
    private String reason;
    private String vetSelection;
    private boolean approved;

    public Appointment() {
    }

    public Appointment(String id, Pet pet, String ownerName, Date appointmentDate, String appointmentTime, String reason, String vetSelection, boolean approved) {
        this.id = id;
        this.pet = pet;
        this.ownerName = ownerName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
        this.vetSelection = vetSelection;
        this.approved = approved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getVetSelection() {
        return vetSelection;
    }

    public void setVetSelection(String vetSelection) {
        this.vetSelection = vetSelection;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
