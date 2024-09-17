package com.petclinic.practice;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class GreetingServiceTest {

    @Test
    void shouldSayHi() {
        var applicationContext = new AnnotationConfigApplicationContext("com.petclinic");
        var greetingService1 = applicationContext.getBean(GreetingService.class);
        var greetingService2 = applicationContext.getBean( GreetingService.class);
    }
}