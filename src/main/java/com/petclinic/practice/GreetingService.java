package com.petclinic.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    public GreetingService(@Qualifier("tintinService") SomeService someService, @Value("${spring.application.name}") String  appName) {
    }

    public String sayHi() {
        return "Hello John";
    }
}

interface SomeService{

}

@Service
class TotoService implements SomeService{

}

