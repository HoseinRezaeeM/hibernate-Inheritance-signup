package ir.hibernate.person.domain;

import ir.hibernate.person.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity<Integer> {
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "birthday")
    private String birthday;

}
