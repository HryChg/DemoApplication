package com.harrychuang.demo.api;

import com.harrychuang.demo.model.Person;
import com.harrychuang.demo.service.PersonService;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person) {
        personService.addPerson(person);
    }
}
