package com.petclinic.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Owner {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private Double accountStatement;

    public Owner() {
    }

    public Owner(Integer id, String firstName, String lastName, Double accountStatement) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountStatement = accountStatement;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAccountStatement() {
        return accountStatement;
    }

    public void setAccountStatement(Double accountStatement) {
        this.accountStatement = accountStatement;
    }
}
