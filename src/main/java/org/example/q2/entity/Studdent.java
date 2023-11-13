package org.example.q2.entity;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Studdent extends Person{

    private String studentNumber;
    private String field;
    private Date enterDate;

    private boolean isActive;
}
