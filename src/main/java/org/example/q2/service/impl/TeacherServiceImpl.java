package org.example.q2.service.impl;

import org.example.q2.entity.Rank;
import org.example.q2.entity.Teacher;
import org.example.q2.repository.TeacherRepository;
import org.example.q2.service.TeacherService;
import org.hibernate.ObjectNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TeacherServiceImpl implements TeacherService {
    private final Scanner input = new Scanner(System.in);
    TeacherRepository teacherRepository;
    public TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository=teacherRepository;
    }
    @Override
    public void save(Teacher teacher)
    {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher loadById(Long id) {
        try {
            return teacherRepository.loadById(id);
        } catch (ObjectNotFoundException e) {
            System.out.println("Person not found for ID: " + id);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Long id,Teacher teacher) {
        teacherRepository.update(id,teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        try {
            teacherRepository.delete(teacher);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Person: " + e.getMessage());
        }

    }

    @Override
    public List<Teacher> loadAll() {
        return teacherRepository.loadAll();
    }

    @Override
    public Boolean contains(String firstName,String lastName) {
        return teacherRepository.contains(firstName,lastName);
    }

    @Override
    public void signUp() {
        Teacher teacher = new Teacher();
        System.out.print("Enter FirstName:");
        teacher.setFirstName(giveStringInput());
        System.out.print("Enter LastName:");
        teacher.setLastName(giveStringInput());
        System.out.print("enter teacherNUmber:");
        teacher.setTeacherNumber(giveStringInput());
        System.out.print("LECTURER, ASSISTANT_PROFESSOR, ASSOCIATE_PROFESSOR, PROFESSOR:");
        String rank1 = giveStringInput();
        Rank rank;
        try {
            rank = Rank.valueOf(rank1);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid rank entered. Please try again.");
            return;
        }
        teacher.setDegree(rank);
        System.out.print("enter email:");
        teacher.setEmail(giveStringInput());
        System.out.print("enter educationalQualification:");
        teacher.setEducationalQualification(giveStringInput());
        System.out.print("enter salary:");
        teacher.setSalary(giveIntegerInput());
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // Create a Validator
        Validator validator = validatorFactory.getValidator();

        // Perform validation
        Set<ConstraintViolation<Teacher>> violations = validator.validate(teacher);
        if (violations.isEmpty()) {
            teacherRepository.save(teacher);
            System.out.println(teacher);
        } else {
            for (ConstraintViolation<Teacher> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
    }
    private String giveStringInput() {
        String i;
        while (true) {
            try {
                i = input.next();

                return i;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Enter just String Please");
            }
        }
    }
    private Double giveIntegerInput() {
        double i;
        while (true) {
            try {
                i = input.nextDouble();
                input.nextLine();
                return i;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Enter just number Please");
            }
        }
    }
}
