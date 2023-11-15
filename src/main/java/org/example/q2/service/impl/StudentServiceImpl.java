package org.example.q2.service.impl;


import org.example.q2.entity.Student;

import org.example.q2.repository.StudentRepository;
import org.example.q2.service.StudentService;

import org.hibernate.ObjectNotFoundException;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentServiceImpl implements StudentService {


    private final Scanner input = new Scanner(System.in);
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student loadById(Long id) {
        try {
            return studentRepository.loadById(id);
        } catch (ObjectNotFoundException e) {
            System.out.println("Person not found for ID: " + id);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void delete(Student student) {
        try {
            studentRepository.delete(student);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Person: " + e.getMessage());
        }

    }

    @Override
    public List<Student> loadAll() {
        return studentRepository.loadAll();
    }

    @Override
    public Boolean contains(String firstName) {
        return studentRepository.contains(firstName);
    }

    @Override
    public void signUp() {
        Student student = new Student();
        System.out.print("Enter FirstName:");
        student.setFirstName(input.next());
        System.out.print("Enter LastName:");
        student.setLastName(input.next());
        System.out.print("enter studentNUmber:");
        student.setStudentNumber(input.next());
        System.out.print("enter field:");
        student.setField(input.next());
        System.out.print("Enter a boolean value (true or false):");
        String userInput = input.next().trim().toLowerCase();
        Boolean value = null;
        if (userInput.equals("true")) {
            value = true;
        } else if (userInput.equals("false")) {
            value = false;
        } else {
            System.out.println("Invalid boolean value entered. Please try again.");
        }
        System.out.print("enter the Age:");
        student.setAge(input.nextInt());

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // Create a Validator
        Validator validator = validatorFactory.getValidator();

        // Perform validation
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        if (violations.isEmpty()) {
            studentRepository.save(student);
        } else {
            for (ConstraintViolation<Student> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
    }
}
