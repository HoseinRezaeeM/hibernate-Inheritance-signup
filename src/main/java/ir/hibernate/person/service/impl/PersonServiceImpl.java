package ir.hibernate.person.service.impl;

import ir.hibernate.person.base.repository.BaseEntityRepository;
import ir.hibernate.person.base.service.impl.BaseEntityServiceImpl;
import ir.hibernate.person.domain.Person;
import ir.hibernate.person.repository.PersonRepository;
import ir.hibernate.person.service.PersonService;

public class PersonServiceImpl extends BaseEntityServiceImpl<Person,Integer, PersonRepository> implements PersonService {

    public PersonServiceImpl(PersonRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Person signUp(String firstname, String lastname) {
        Person person =new Person(firstname,lastname,null);
        baseRepository.save(person);
        return person;
    }
}
