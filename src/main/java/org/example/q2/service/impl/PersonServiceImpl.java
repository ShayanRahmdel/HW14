package org.example.q2.service.impl;

import org.example.q2.entity.Person;
import org.example.q2.repository.PersonRepository;
import org.example.q2.service.PersonService;

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
    public Person loadById(Long id) {
       return personRepository.loadById(id);

    }

    @Override
    public void update(Person person, Long id) {
        personRepository.update(person,id);
    }
}
