package com.harrychuang.demo.dao;

import com.harrychuang.demo.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("fakeDao") // NOTE-HC Tell Spring-boot this is a repository (datasource) and it is named
// `fakeDao`
public class FakePersonDataAccessService implements PersonDao {

  private static List<Person> DB = new ArrayList<>();

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName()));
    return 1; // NOTE-HC Return 1 to indicate success. Opposite is true for 0
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }
}
