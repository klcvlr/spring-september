package com.petclinic.web;

import com.petclinic.core.Owner;
import com.petclinic.core.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/{id}")
    public Optional<Owner> findById(@PathVariable Integer id) {
        return ownerService.findById(id);
    }

    @GetMapping(value = "/search")
    public Optional<Owner> findByFirstName(@RequestParam String firstName) {
        return ownerService.findByFirstName(firstName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner create(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }


}
