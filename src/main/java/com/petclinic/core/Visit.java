package com.petclinic.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getPurpose() {
        return purpose;
    }
}
