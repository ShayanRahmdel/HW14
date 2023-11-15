package org.example.q2.repository.impl;

import org.example.q2.entity.Person;
import org.example.q2.entity.Student;
import org.example.q2.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    Session session;

    public StudentRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Student student) {
        try {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }

    @Override
    public Student loadById(Long id) {
        try {
            session.beginTransaction();
            return session.load(Student.class,id);

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return null;
    }

    @Override
    public void update(Long id,Student student) {

        try {
            session.beginTransaction();
            Student oldStudent = session.load(Student.class, id);
            oldStudent.setFirstName(student.getFirstName());
            oldStudent.setLastName(student.getLastName());
            oldStudent.setStudentNumber(student.getStudentNumber());
            oldStudent.setField(student.getField());
            oldStudent.setActive(student.isActive());
            oldStudent.setAge(student.getAge());

            session.update(oldStudent);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
           // String studentNumber, String field, boolean isActive, int age
        }
    }

    @Override
    public void delete(Student student) {

        try {
            session.beginTransaction();
            Person person1 = session.get(Person.class, student.getId());
            session.delete(person1);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public List<Student> loadAll() {
        String hql = "select f from Student f";
        Query<Student> query = session.createQuery(hql, Student.class);
        return query.list();

    }

    @Override
    public Boolean contains(String firstName,String lastName) {
        String hql = "select count(*) from Student p where p.firstName = :firstName and p.lastName =:lastName";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("firstName",firstName);
        query.setParameter("lastName",lastName);
        Long aLong = query.uniqueResult();
        return aLong !=null && aLong>0;
    }
}
