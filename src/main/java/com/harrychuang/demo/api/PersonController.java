package com.harrychuang.demo.api;

import com.harrychuang.demo.model.Person;
import com.harrychuang.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // NOTE-HC Delcare this class as a REST API Controller for Spring Boot
public class PersonController {
  private final PersonService personService;

  @Autowired // NOTE-HC Automatically inject a PersonService class into this class
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public void addPerson(Person person) {
    personService.addPerson(person);
  }
}
