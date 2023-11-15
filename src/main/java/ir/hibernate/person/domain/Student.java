package ir.hibernate.person.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person{
    @Column(name = "student_id",nullable = false)
    @Min(value = 100,message = "student id can't under 1000")
    private Integer studentId;
    @Column(name = "field_study",nullable = false)
    private String fieldStudy;


    public Student(String firstname, String lastname, String birthday, Integer studentId, String fieldStudy) {
        super(firstname, lastname, birthday);
        this.studentId = studentId;
        this.fieldStudy = fieldStudy;
    }
}
