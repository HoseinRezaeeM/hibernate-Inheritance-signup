package ir.hibernate.person.service;

import ir.hibernate.person.base.service.BaseEntityService;
import ir.hibernate.person.domain.Person;
import ir.hibernate.person.domain.Teacher;

public interface PersonService  extends BaseEntityService<Person, Integer> {

    Person signUp(String firstname, String lastname);
}
