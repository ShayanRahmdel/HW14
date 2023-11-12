package org.example.q2.service;

import org.example.q2.entity.Person;

import javax.persistence.Id;

public interface PersonService {

    void save(Person person);

    Person loadById(Long id);

    void update(Person person,Long id);
}
