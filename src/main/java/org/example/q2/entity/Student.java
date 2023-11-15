package org.example.q2.entity;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Student extends Person{


    @Column(unique = true,length = 4)
    private String studentNumber;

    @NonNull
    private String field;
    @Temporal(value = TemporalType.DATE)
    private Date enterDate;

    private boolean isActive;
    @Max(value = 50,message = "age should not be greater than 50")
    @Min(value = 15,message = "age should not be less than 15")
    private int age;

    public Student(String firstName, String lastName, Date dob, String studentNumber, String field, Date enterDate, boolean isActive, int age) {
        super(firstName, lastName, dob);
        this.studentNumber = studentNumber;
        this.field = field;
        this.enterDate = enterDate;
        this.isActive = isActive;
        this.age = age;
    }

    public Student(String firstName, String lastName, String studentNumber, String field, boolean isActive, int age) {
        super(firstName, lastName);
        this.studentNumber = studentNumber;
        this.field = field;
        this.isActive = isActive;
        this.age = age;
    }
}
