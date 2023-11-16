package ir.hibernate.person.repository.impl;
//Hosen Rezaei
import ir.hibernate.person.base.repository.impl.BaseEntityRepositoryImpl;
import ir.hibernate.person.domain.Person;
import ir.hibernate.person.repository.PersonRepository;
import org.hibernate.Session;

public class PersonRepositoryImpl extends BaseEntityRepositoryImpl<Person, Integer>
        implements PersonRepository {
    public PersonRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    protected String getEntityTableName() {
        return "Person";
    }
}
