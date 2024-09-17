package com.petclinic.core;

import java.time.LocalDate;

public class Visit {
    private final int id;
    private final String referenceNumber;
    private final LocalDate date;
    private final String purpose;

    public Visit(int id, String referenceNumber, LocalDate date, String purpose) {
        this.id = id;
        this.referenceNumber = referenceNumber;
        this.date = date;
        this.purpose = purpose;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getPurpose() {
        return purpose;
    }
}
