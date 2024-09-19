package com.petclinic.core;

import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner findByFirstName(String firstName) {
        return ownerRepository.findByFirstName(firstName);
    }

    public Owner findByFirstNameWithPets(String firstName) {
        return ownerRepository.findByFirstNameWithPets(firstName);
    }

    public void save(Owner owner) {
        ownerRepository.save(owner);
    }
}
