package com.app.splitwise.testify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ServiceTest {

    @Autowired
    RepositoryTest repositoryTest;

    public Person createPerson(Person person) {
        return  repositoryTest.save(person);
    }

//    public Person createParent(Person parents) {
//        return repositoryTest.save(parents);
//    }
}
