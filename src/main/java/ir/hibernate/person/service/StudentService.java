package ir.hibernate.person.service;

import ir.hibernate.person.base.service.BaseEntityService;
import ir.hibernate.person.domain.Person;
import ir.hibernate.person.domain.Student;
import ir.hibernate.person.domain.Teacher;

public interface StudentService  extends BaseEntityService<Student, Integer> {
    Student signUp(Integer studentId,String fieldstudy);
}
