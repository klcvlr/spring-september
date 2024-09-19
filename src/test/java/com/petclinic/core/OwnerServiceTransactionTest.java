package com.petclinic.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class OwnerServiceTransactionTest {

    @Autowired
    private OwnerService ownerService;

    @Test
    @Transactional
    void shouldRunInTransaction() {
        assertThat(TransactionSynchronizationManager.isActualTransactionActive()).isTrue();
    }

    @Test
    void shouldTransferFunds() {
        var ownerToCredit = ownerService.save(new Owner(0, "Jimi", "Hendrix", 0.0));
        var ownerToDebit = ownerService.save(new Owner(0, "Robert", "Plant", 1000.0));
        ownerService.transferFunds(ownerToCredit, ownerToDebit, 200);
        var ownerToCreditRetrieved = ownerService.findByFirstName("Jimi");
        assertThat(ownerToCreditRetrieved.getAccountStatement()).isEqualTo(200);
        var ownerToDebitRetrieved = ownerService.findByFirstName("Robert");
        assertThat(ownerToDebitRetrieved.getAccountStatement()).isEqualTo(800);
    }

    @Test
    void shouldNotTransferFunds() {
        var ownerToCredit = ownerService.save(new Owner(0, "Jimi", "Hendrix", 0.0));
        var ownerToDebit = ownerService.save(new Owner(0, "Robert", "Plant", 100.0));

        assertThatThrownBy(() -> ownerService.transferFunds(ownerToCredit, ownerToDebit, 200)).isInstanceOf(RuntimeException.class);

        var ownerToCreditRetrieved = ownerService.findByFirstName("Jimi");
        var ownerToDebitRetrieved = ownerService.findByFirstName("Robert");

        assertThat(ownerToCreditRetrieved.getAccountStatement()).isEqualTo(0.0);
        assertThat(ownerToDebitRetrieved.getAccountStatement()).isEqualTo(100.0);
    }

}
