package org.example.q2.service.impl;

import org.example.q2.entity.Person;
import org.example.q2.repository.PersonRepository;
import org.example.q2.service.PersonService;
import org.hibernate.ObjectNotFoundException;

import java.util.Date;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
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
    public void update(Long id, Person person) {
        personRepository.update(id, person);
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
    public Boolean contains(String firstName,String lastName) {
        return personRepository.contains(firstName,lastName);
    }

    @Override
    public void signUp(String firstName, String lastName, Date dob) {
        Person person = new Person(firstName, lastName,dob);
        personRepository.save(person);
         System.out.println(person);
    }
}
