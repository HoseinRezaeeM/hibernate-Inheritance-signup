package ir.hibernate.person.domain;

import ir.hibernate.person.base.domain.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "person_id")
public class Person extends BaseEntity<Integer> {
    @Column(name = "first_name")
    String firstname;
    @Column(name = "last_name")
    String lastname;
    @Column(name = "birthday")
    String birthday;

}
