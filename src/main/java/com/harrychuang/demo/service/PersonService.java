package com.harrychuang.demo.service;

import com.harrychuang.demo.dao.PersonDAO;
import com.harrychuang.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // NOTE-HC You can also declare this as @Component. We stick to @Service as it is more specific.
public class PersonService {
    // NOTE-HC We are using interface here so that we can temporary use the FakePersonDataAccessService
    //  as a mockDB. This makes it very say to switch to a real DB in the future by simple passing int
    //  a DB class that implements the same interface `PersonDAO`
    private final PersonDAO personDao;

    /**
     * NOTE-HC:
     * - @Autowired: Autowiring the PersonDAO interface into this class
     * - @Qualifier("fakeDAO"): By giving PersonaDAO class a Unique Identifier on the class, Spring-boot lets you decide
     * which specific PersonaDAO you want to wire up and use it
     * - Because we can have multiple implementation of interface PersonDAO, we must have a way to distinguish them
     * - add @Qualifier
     */
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDAO personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
}
