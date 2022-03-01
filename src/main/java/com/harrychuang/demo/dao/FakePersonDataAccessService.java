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
    return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
  }

  @Override
  public int deletePersonById(UUID id) {
    Optional<Person> personMaybe = selectPersonById(id);
    if (personMaybe.isEmpty()) {
      return 0;
    }
    DB.remove(personMaybe.get());
    return 1;
  }

  @Override
  public int updatePersonById(UUID id, Person update) {
    return selectPersonById(id)
        .map(
            person -> {
              // QUES-HC Isn't p unused?
              int indexOfPersonToUpdate = DB.indexOf(person);
              if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                return 1;
              }
              return 0;
            })
        .orElse(0);
  }
}
