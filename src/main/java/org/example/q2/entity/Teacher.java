package org.example.q2.entity;


import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Teacher extends Person {
    @Column(unique = true,length = 4)
    private String teacherNumber;
    @Enumerated(value = EnumType.STRING)
    private Rank degree;
    @Email(message = "Email should be Valid")
    private String email;
    @Column(length = 30)
    private String educationalQualification;
    @Min(value = 100,message = "Salary should not be less than 100")
    private Double salary;




    public Teacher(String firstName, String lastName, String teacherNumber, Rank degree, String email, String educationalQualification, Double salary) {
        super(firstName, lastName);
        this.teacherNumber = teacherNumber;
        this.degree = degree;
        this.email = email;
        this.educationalQualification = educationalQualification;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return      "\n"+
                "============"+
                "Teacher " +
                "\n firstName = " + getFirstName() +
                "\n lastName = " + getLastName() +
                "\n teacherNumber = '" + teacherNumber + '\'' +
                ",\n degree = " + degree +
                ",\n email = '" + email + '\'' +
                ",\n educationalQualification = '" + educationalQualification + '\'' +
                ",\n salary = " + salary;
    }
}
