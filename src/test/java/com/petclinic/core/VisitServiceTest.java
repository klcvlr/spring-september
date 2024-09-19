package com.petclinic.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class VisitServiceTest {

    @Autowired
    private VisitService visitService;
    @Autowired
    private VisitRepository visitRepository;

    @BeforeEach
    void setUp() {
        Visit visit = new Visit(null, "refNum", LocalDate.of(2024, 9, 18), "Some purpose");
        visit.setPet(new Pet(null, "dog", "luna"));
        visit.setOwner(new Owner(null, "joe", "satriani", 1000.0));
        visitRepository.save(visit);
    }

    @Test
    void shouldFindByReferenceNumber() {
        Visit actual = visitService.findByReferenceNumber("refNum");

        assertThat(actual.getId()).isEqualTo(1);
        assertThat(actual.getReferenceNumber()).isEqualTo("refNum");
        assertThat(actual.getDate()).isEqualTo( LocalDate.of(2024, 9, 18));
        assertThat(actual.getPurpose()).isEqualTo("Some purpose");
    }

    @Test
    void shouldNotFindReferenceNumber() {
        Visit visit = visitService.findByReferenceNumber("DOES_NOT_EXIST");

        assertThat(visit).isNull();
    }

    @Test
    void shouldFindVisitWithPet() {
        Visit visit = visitService.findByReferenceNumber("refNum");

        assertThat(visit.getPet().getName()).isEqualTo("luna");
    }

    @Test
    void shouldFindVisitWithOwner() {
        Visit visit = visitService.findByReferenceNumber("refNum");

        assertThat(visit.getOwner().getFirstName()).isEqualTo("joe");
    }

}
