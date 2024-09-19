package com.petclinic.core;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String referenceNumber;
    private LocalDate date;
    private String purpose;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Pet pet;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name ="owner_id")
    private Owner owner;


    public Visit() {
    }

    public Visit(Integer id, String referenceNumber, LocalDate date, String purpose) {
        this.id = id;
        this.referenceNumber = referenceNumber;
        this.date = date;
        this.purpose = purpose;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
