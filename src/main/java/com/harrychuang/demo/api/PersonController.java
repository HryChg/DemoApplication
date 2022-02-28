package com.harrychuang.demo.api;

import com.harrychuang.demo.model.Person;
import com.harrychuang.demo.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/person") // NOTE-HC Map a specific route to this controller
@RestController // NOTE-HC Declare this class as a REST API Controller for Spring Boot
public class PersonController {

  private final PersonService personService;

  @Autowired // NOTE-HC Automatically inject a PersonService class into this class
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  // @formatter:off
  /**
   * NOTE-HC
   *  - `@PostMapping`: declare this method as a post endpoint
   *  - `@RequestBody`: declare this parameter as the body of the request.
   *      Since Person's constructor params are already declared `@JsonProperty("XXX")`,
   *      Spring-boot can automatically map the JSON properties to the class properties.
   */
  // @formatter:on
  @PostMapping
  public void addPerson(@RequestBody Person person) {
    personService.addPerson(person);
  }

  @GetMapping
  public List<Person> getAllPeople() {
    return personService.getAllPeople();
  }
}
