package org.example.q2.repository;

import org.example.q2.entity.Person;

import java.util.List;

public interface PersonRepository {
    void save(Person person);
    Person loadById(Long id);

    void update(Person person,Long id);

    void delete(Long id);

    List<Person> loadAll();

    Boolean contains();

}
