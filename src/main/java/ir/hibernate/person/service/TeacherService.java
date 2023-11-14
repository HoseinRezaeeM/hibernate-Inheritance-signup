package ir.hibernate.person.service;


import ir.hibernate.person.base.service.BaseEntityService;
import ir.hibernate.person.domain.Degree;
import ir.hibernate.person.domain.Teacher;

public interface TeacherService extends BaseEntityService<Teacher, Integer> {
    Teacher signUp(Integer teacherId, Degree degree);
}
