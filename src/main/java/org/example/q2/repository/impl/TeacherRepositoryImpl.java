package org.example.q2.repository.impl;

import org.example.q2.entity.Person;
import org.example.q2.entity.Teacher;
import org.example.q2.repository.TeacherRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherRepositoryImpl  implements TeacherRepository {
    Session session;

    public TeacherRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Teacher teacher) {
        try {
            session.beginTransaction();
            session.persist(teacher);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }

    @Override
    public Teacher loadById(Long id) {
        try {
            session.beginTransaction();
            return session.load(Teacher.class,id);

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return null;
    }

    @Override
    public void update(Teacher teacher) {

        try {
            session.beginTransaction();
            session.update(teacher);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }

    @Override
    public void delete(Teacher teacher) {

        try {
            session.beginTransaction();
            Person person1 = session.get(Teacher.class, teacher.getId());
            session.delete(person1);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public List<Teacher> loadAll() {
        String hql = "select f from Teacher f";
        Query<Teacher> query = session.createQuery(hql, Teacher.class);
        return query.list();

    }

    @Override
    public Boolean contains(String firstName) {
        String hql = "select count(*) from Teacher p where p.firstName = :firstName";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("firstName",firstName);
        Long aLong = query.uniqueResult();
        return aLong !=null && aLong>0;
    }
}
