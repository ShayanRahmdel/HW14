package org.example.q2.repository.impl;

import org.example.q2.entity.Person;
import org.example.q2.repository.PersonRepository;
import org.hibernate.Session;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    Session session;
    public PersonRepositoryImpl(Session session){
        this.session=session;
    }
    @Override
    public void save() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public List<Person> loadAll() {
        return null;
    }

    @Override
    public Boolean contains() {
        return null;
    }
}
