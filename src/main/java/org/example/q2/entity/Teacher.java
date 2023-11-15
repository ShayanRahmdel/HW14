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
@ToString
public class Teacher extends Person {
    @Column(unique = true,length = 4)
    private String teacherNumber;
    @Enumerated(value = EnumType.STRING)
    private Rank degree;
    @Email(message = "Email should be Valid")
    private String email;
    @Column(length = 30)
    private String educationalQualification;
    @Min(value = 10000000,message = "Salary should not be less than 10000000")
    private Double salary;




    public Teacher(String firstName, String lastName, String teacherNumber, Rank degree, String email, String educationalQualification, Double salary) {
        super(firstName, lastName);
        this.teacherNumber = teacherNumber;
        this.degree = degree;
        this.email = email;
        this.educationalQualification = educationalQualification;
        this.salary = salary;
    }
}
