package org.example.q2.repository;

import org.example.q2.entity.Person;
import org.example.q2.entity.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);
    Student loadById(Long id);

    void update(Long id,Student student);

    void delete(Student student);

    List<Student> loadAll();

    Boolean contains(String firstName,String lastName);
}
