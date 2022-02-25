package com.harrychuang.demo.dao;

import com.harrychuang.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakePersonDataAccessService implements PersonDAO {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1; // NOTE-HC Return 1 to indicate success. Opposite is true for 0
    }
}
