package ir.hibernate.person.repository.impl;

import ir.hibernate.person.base.repository.impl.BaseEntityRepositoryImpl;
import ir.hibernate.person.domain.Student;
import ir.hibernate.person.repository.StudentRepository;
import org.hibernate.Session;

public class StudentRepositoryImpl extends BaseEntityRepositoryImpl<Student, Integer>
        implements StudentRepository {
    public StudentRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    protected String getEntityTableName() {
        return "Student";
    }
}
