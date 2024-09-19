package com.petclinic.web;

import com.petclinic.core.Visit;
import com.petclinic.core.VisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VisitController {


    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/visit/{id}")
    public Optional<Visit> findById(@PathVariable Integer id) {
        return visitService.findById(id);
    }

}
