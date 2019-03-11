package com.app.splitwise.testify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/parents")
public class ControllerTest {

    @Autowired
    ServiceTest serviceTest;

    @PostMapping
    private Person createPerson(@RequestBody Person person) {
        return serviceTest.createPerson(person);
    }
/*
    @PostMapping
    private Parents createParent(@RequestBody Parents parents){
        return serviceTest.createParent(parents);
    }*/
}
