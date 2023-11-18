package ir.hibernate.person.base.domain;

import lombok.Getter;
import lombok.Setter;
//Hosen Rezaei https://www.linkedin.com/in/hosein-rezaei-developer
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class BaseEntity<ID extends Serializable> {
    @Id @GeneratedValue
    private ID id;
}



//Hosein Rezaei
