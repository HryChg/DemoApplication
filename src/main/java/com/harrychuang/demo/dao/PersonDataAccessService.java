package com.harrychuang.demo.dao;

import com.harrychuang.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

// TODO-HC Spin up a postgres container and implement this
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

  @Override
  public int insertPerson(UUID id, Person peron) {
    return 0;
  }

  @Override
  public List<Person> selectAllPeople() {
    return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    return Optional.empty();
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
