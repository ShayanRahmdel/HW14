package org.example.q2.service;

import org.example.q2.entity.Person;
import org.example.q2.entity.Rank;
import org.example.q2.entity.Teacher;

import java.util.List;

public interface TeacherService {
    void save(Teacher teacher);

    Teacher loadById(Long id);

    void update(Long id,Teacher teacher);

    void delete(Teacher teacher);

    List<Teacher> loadAll();

    Boolean contains(String firstName,String lastName);

    void signUp();
}
