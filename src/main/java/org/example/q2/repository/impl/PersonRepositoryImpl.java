package org.example.q2.repository.impl;

import org.example.q2.entity.Person;
import org.example.q2.repository.PersonRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    Session session;

    public PersonRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Person person) {
        try {
            session.beginTransaction();
            session.persist(person);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }

    @Override
    public Person loadById(Long id) {
        try {
            session.beginTransaction();
            return session.load(Person.class,id);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return null;
    }

    @Override
    public void update(Person person) {

        try {
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }

    @Override
    public void delete(Person person) {

        try {
            session.beginTransaction();
            Person person1 = session.get(Person.class, person.getId());
            session.delete(person1);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public List<Person> loadAll() {
        String hql = "select f from Person f";
        Query<Person> query = session.createQuery(hql, Person.class);
        return query.list();

    }

    @Override
    public Boolean contains(String firstName) {
        String hql = "select count(*) from Person p where p.firstName = :firstName";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("firstName",firstName);
        Long aLong = query.uniqueResult();
        return aLong !=null && aLong>0;
    }
}
