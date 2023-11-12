package org.example.q2.repository;

import org.example.q2.entity.Person;

import java.util.List;

public interface PersonRepository {
    void save();
    void update();

    void delete();

    List<Person> loadAll();

    Boolean contains();

}
