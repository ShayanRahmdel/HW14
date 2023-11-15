package org.example.q2.service;

import org.example.q2.entity.Person;
import org.example.q2.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);

    Student loadById(Long id);

    void update(Student student);

    void delete(Student student);

    List<Student> loadAll();

    Boolean contains(String firstName);

    void signUp();
}
