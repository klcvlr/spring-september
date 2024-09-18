package com.petclinic.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VisitServiceTest {

    @Autowired
    private VisitService visitService;
    @Autowired
    private VisitRepository visitRepository;

    @BeforeEach
    void setUp() {
        Visit visit = new Visit(null, "refNum", LocalDate.of(2024, 9, 18), "Some purpose");
        visitRepository.save(visit);
    }

    @Test
    void shouldFindByReferenceNumber() {
        Visit actual = visitService.findByReferenceNumber("refNum");

        assertThat(actual.getId()).isEqualTo(1);
        assertThat(actual.getReferenceNumber()).isEqualTo("refNum");
        assertThat(actual.getDate()).isEqualTo(LocalDate.now());
        assertThat(actual.getPurpose()).isEqualTo("Some purpose");
    }

    @Test
    void shouldNotFindReferenceNumber() {
        Visit visit = visitService.findByReferenceNumber("DOES_NOT_EXIST");

        assertThat(visit).isNull();
    }

}
