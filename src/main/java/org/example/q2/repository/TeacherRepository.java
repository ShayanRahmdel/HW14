package org.example.q2.repository;

import org.example.q2.entity.Person;
import org.example.q2.entity.Teacher;

import java.util.List;

public interface TeacherRepository {
    void save(Teacher person);
    Teacher loadById(Long id);

    void update(Teacher teacher);

    void delete(Teacher teacher);

    List<Teacher> loadAll();

    Boolean contains(String firstName);
}
