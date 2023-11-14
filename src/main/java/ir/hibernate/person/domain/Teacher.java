package ir.hibernate.person.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person {
    @Column(name = "teacher_id",nullable = false)
    private Integer teacherId;
    @Column(name = "degree",nullable = false)
    @Enumerated(EnumType.STRING)
    private Degree degree;
    @Column(name = "master_degree")
    @Enumerated(EnumType.STRING)
    private MasterDegree masterDegree;
    @Column(name = "salary")
    private Long salary;

    public Teacher(String firstname, String lastname, String birthday, Integer teacherId, Degree degree, MasterDegree masterDegree, Long salary) {
        super(firstname, lastname, birthday);
        this.teacherId = teacherId;
        this.degree = degree;
        this.masterDegree = masterDegree;
        this.salary = salary;
    }
}
