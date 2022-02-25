package com.harrychuang.demo.service;

import com.harrychuang.demo.dao.PersonDAO;
import com.harrychuang.demo.model.Person;

public class PersonService {
    // NOTE-HC We are using interface here so that we can temporary use the FakePersonDataAccessService
    //  as a mockDB. This makes it very say to switch to a real DB in the future by simple passing int
    //  a DB class that implements the same interface `PersonDAO`
    private final PersonDAO personDao;

    public PersonService(PersonDAO personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
}
