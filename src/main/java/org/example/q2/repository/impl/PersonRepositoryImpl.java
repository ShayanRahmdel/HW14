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
        String hql = "FROM Person f WHERE f.id=:id";
        Query<Person> query = session.createQuery(hql, Person.class);
        query.setParameter("id",id);
        Person singleResult = query.getSingleResult();
        session.close();
        return singleResult;

    }

    @Override
    public void update(Person person, Long id) {
        String hql = "update Person f set f.firstName=:firstName ,f.lastName=:lastName where f.id=:id";
        try {
            session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("firstName", person.getFirstName());
            query.setParameter("lastName",person.getLastName());
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        String hql="delete from Person where id=:id";
        try {
            session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
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
    public Boolean contains() {
        return null;
    }
}
