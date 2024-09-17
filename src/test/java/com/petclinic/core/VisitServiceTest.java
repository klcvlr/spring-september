package com.petclinic.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    void shouldFindByReferenceNumber() {
        Visit actual = visitService.findByReferenceNumber("toto");

        assertThat(actual.getId()).isEqualTo(1);
        assertThat(actual.getReferenceNumber()).isEqualTo("toto");
        assertThat(actual.getDate()).isBefore(LocalDate.now());
        assertThat(actual.getPurpose()).isEqualTo("no purpose");
    }
}