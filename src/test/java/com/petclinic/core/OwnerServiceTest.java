package com.petclinic.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    @BeforeEach
    void setUp() {
        Owner owner = new Owner(null, "joe", "satriani", 1000.0);
        owner.setPets(List.of(new Pet(null, "dog", "Luna"), new Pet(null, "cat", "Miro")));
        ownerService.save(owner);
    }


    @Test
    void shouldFindOwnerByFirstName() {
        Owner owner = ownerService.findByFirstName("joe");

        assertThat(owner).isNotNull();
        assertThat(owner.getFirstName()).isEqualTo("joe");
    }

    @Test
    void shouldFindOwnerWithPets() {
        var owner = ownerService.findByFirstNameWithPets("joe");

        assertThat(owner.getPets()).extracting(Pet::getName).contains("Luna");
    }
}