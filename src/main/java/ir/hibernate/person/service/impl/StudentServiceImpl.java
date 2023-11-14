package ir.hibernate.person.service.impl;

import ir.hibernate.person.base.service.impl.BaseEntityServiceImpl;
import ir.hibernate.person.domain.Student;
import ir.hibernate.person.repository.StudentRepository;
import ir.hibernate.person.service.StudentService;

public class StudentServiceImpl  extends BaseEntityServiceImpl<Student,Integer, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Student signUp(Integer studentId,String fieldstudy) {
        Student student =new Student(studentId,fieldstudy);
        baseRepository.save(student);
        return student;
    }
}
