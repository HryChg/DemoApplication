package com.harrychuang.demo.dao;

import com.harrychuang.demo.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("fakeDao") // NOTE-HC Tell Spring-boot this is a repository (datasource) and it is named
// `fakeDao`
public class FakePersonDataAccessService implements PersonDao {

  private static final List<Person> DB = new ArrayList<>();

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName()));
    return 1; // NOTE-HC Return 1 to indicate success. Opposite is true for 0
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    // TODO-HC Read more about Java Stream
    return DB.stream()
        .filter(person -> person.getId().equals(id))
        .findFirst();
  }

  @Override
  public int deletePersonById(UUID id) {
    return 0;
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    return 0;
  }
}
