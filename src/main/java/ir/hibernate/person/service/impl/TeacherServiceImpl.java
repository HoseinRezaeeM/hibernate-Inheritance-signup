package ir.hibernate.person.service.impl;

import ir.hibernate.person.base.service.impl.BaseEntityServiceImpl;
import ir.hibernate.person.domain.Degree;
import ir.hibernate.person.domain.Teacher;
import ir.hibernate.person.repository.TeacherRepository;
import ir.hibernate.person.service.TeacherService;

import java.util.Date;

public class TeacherServiceImpl extends BaseEntityServiceImpl<Teacher, Integer, TeacherRepository> implements TeacherService {
    public TeacherServiceImpl(TeacherRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Teacher signUp(Integer teacherId, Degree degree) {
        Teacher teacher =new Teacher(teacherId,degree,null,null);
        baseRepository.save(teacher);
        return teacher;
    }
}
