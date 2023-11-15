package ir.hibernate.person.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person {
    @Column(name = "teacher_id",nullable = false)
    @Min(value = 100 ,message = "teacherId can't under 100")
    private Integer teacherId;
    @Column(name = "degree",nullable = false)
    @Enumerated(EnumType.STRING)
    private Degree degree;
    @Column(name = "master_degree")
    @Enumerated(EnumType.STRING)
    private MasterDegree masterDegree;
    @Column(name = "salary")
    @Max(value = 30000000,message = "salary can't above 30000000")
    private Long salary;

    public Teacher(String firstname, String lastname, String birthday, Integer teacherId, Degree degree, MasterDegree masterDegree, Long salary) {
        super(firstname, lastname, birthday);
        this.teacherId = teacherId;
        this.degree = degree;
        this.masterDegree = masterDegree;
        this.salary = salary;
    }
}
