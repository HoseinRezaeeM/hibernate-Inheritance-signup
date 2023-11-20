package ir.hibernate.person.base.domain;

import lombok.Getter;
import lombok.Setter;
//Hosen Rezaei
import javax.persistence.*;
import java.io.Serializable;
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class BaseEntity<ID extends Serializable> {
    @Id @GeneratedValue
    private ID id;
}



//Hosein Rezaei