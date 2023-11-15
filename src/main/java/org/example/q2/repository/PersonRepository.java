package org.example.q2.repository;

import org.example.q2.entity.Person;

import java.util.List;

public interface PersonRepository {
    void save(Person person);
    Person loadById(Long id);

    void update(Long id,Person person);

    void delete(Person person);

    List<Person> loadAll();

    Boolean contains(String firstName,String lastName);

}
