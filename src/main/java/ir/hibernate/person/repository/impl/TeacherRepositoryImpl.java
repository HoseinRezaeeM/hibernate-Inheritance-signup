package ir.hibernate.person.repository.impl;

import ir.hibernate.person.base.repository.impl.BaseEntityRepositoryImpl;
import ir.hibernate.person.domain.Teacher;
import ir.hibernate.person.repository.TeacherRepository;
import org.hibernate.Session;

public class TeacherRepositoryImpl extends BaseEntityRepositoryImpl<Teacher, Integer> implements TeacherRepository {
    public TeacherRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    protected String getEntityTableName() {
        return "Teacher";
    }
}
