package ir.hibernate.person.base.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class BaseEntity<ID extends Serializable> {
    @Id @GeneratedValue
    private ID id;
}
