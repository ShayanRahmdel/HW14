package org.example.q2.service.impl;

import org.example.q2.entity.Person;
import org.example.q2.repository.PersonRepository;
import org.example.q2.service.PersonService;
import org.hibernate.ObjectNotFoundException;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository=personRepository;
    }
    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person loadById(Long id) throws ObjectNotFoundException {
        try {
            return personRepository.loadById(id);
        } catch (ObjectNotFoundException e) {
            System.out.println("Person not found for ID: " + id);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Person person) {
        personRepository.update(person);
    }

    @Override
    public void delete(Person person) {
        try {
            personRepository.delete(person);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Person: " + e.getMessage());
        }

    }

    @Override
    public List<Person> loadAll() {
        return personRepository.loadAll();
    }

    @Override
    public Boolean contains(String firstName) {
        return personRepository.contains(firstName);
    }

    @Override
    public void signUp(String firstName, String lastName) {
        Person person = new Person(firstName,lastName);
        personRepository.save(person);
        System.out.println(personRepository.loadById(person.getId()));
    }
}
