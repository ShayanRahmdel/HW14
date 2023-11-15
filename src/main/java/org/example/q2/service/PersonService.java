package org.example.q2.service;

import org.example.q2.entity.Person;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public interface PersonService {

    void save(Person person);

    Person loadById(Long id);

    void update(Long id,Person person);

    void delete(Person person);

    List<Person> loadAll();

    Boolean contains(String firstName);

    void signUp(String firstName, String lastName, Date dob);

}
