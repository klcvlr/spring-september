package com.petclinic.practice;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GreetingServiceTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private GreetingService greetingService;

    @Test
    void shouldSayHi() {
        String greeting = greetingService.sayHi();

        assertThat(greeting).isEqualTo("Hello John");
    }

    @Test
    void shouldGetBeanDefinitionCount() {
        var beanDefinitionCount = applicationContext.getBeanDefinitionCount();

        assertThat(beanDefinitionCount).isPositive();
    }

    // Not a real test (no assertions), only there for the logger demonstration purpose
    @Test
    void displayBeanDefinitionNames(){
        var logger = LoggerFactory.getLogger(GreetingServiceTest.class);

        var beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            logger.info("beanDefinitionName = {}", beanDefinitionName);
        }
    }
}