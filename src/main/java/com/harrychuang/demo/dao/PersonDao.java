package com.harrychuang.demo.dao;

import com.harrychuang.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

  int insertPerson(UUID id, Person peron);

  // NOTE-HC Provides default method for insertPerson so that children class are not required to
  // implement
  // QUES-HC How is this different from abstract class tho?
  default int insertPerson(Person person) {
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }

  List<Person> selectAllPeople();

  Optional<Person> selectPersonById(UUID id);

  int deletePersonById(UUID id);

  int updatePersonById(UUID id, Person person);
}
