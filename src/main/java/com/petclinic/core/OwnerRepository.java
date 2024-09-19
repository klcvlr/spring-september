package com.petclinic.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Optional<Owner> findByFirstName(String firstName);

    @Query("select o from Owner o left join fetch o.pets where o.firstName = :firstName")
    Owner findByFirstNameWithPets(String firstName);
}
