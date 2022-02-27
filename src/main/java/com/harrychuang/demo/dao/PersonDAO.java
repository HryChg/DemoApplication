package com.harrychuang.demo.dao;

import com.harrychuang.demo.model.Person;

import java.util.UUID;

public interface PersonDAO {
  int insertPerson(UUID id, Person peron);

  // NOTE-HC Provides default method for insertPerson so that children class are not required to
  // implement
  // QUES-HC How is this different from abstract class tho?
  default int insertPerson(Person person) {
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }
}
