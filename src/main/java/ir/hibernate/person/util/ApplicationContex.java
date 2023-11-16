package ir.hibernate.person.util;

import ir.hibernate.person.repository.PersonRepository;
import ir.hibernate.person.repository.StudentRepository;
import ir.hibernate.person.repository.TeacherRepository;
import ir.hibernate.person.repository.impl.PersonRepositoryImpl;
import ir.hibernate.person.repository.impl.StudentRepositoryImpl;
import ir.hibernate.person.repository.impl.TeacherRepositoryImpl;
import ir.hibernate.person.service.PersonService;
import ir.hibernate.person.service.StudentService;
import ir.hibernate.person.service.TeacherService;
import ir.hibernate.person.service.impl.PersonServiceImpl;
import ir.hibernate.person.service.impl.StudentServiceImpl;
import ir.hibernate.person.service.impl.TeacherServiceImpl;
import org.hibernate.Session;


public class ApplicationContex {
    private static final Session session;
    private static final PersonRepository personRepository;
    private static final PersonService personService;
    private static final StudentRepository studentRepository;
    private static final StudentService studentService;
    private static final TeacherRepository teacherRepository;
    private static final TeacherService teacherService;

    static {
        session = SessionFactoryProvider.getSessionFactory().openSession();
        personRepository = new PersonRepositoryImpl(session);
        personService = new PersonServiceImpl(personRepository);
        studentRepository = new StudentRepositoryImpl(session);
        studentService = new StudentServiceImpl(studentRepository);
        teacherRepository = new TeacherRepositoryImpl(session);
        teacherService = new TeacherServiceImpl(teacherRepository);
//Hosen Rezaei
    }

    public static PersonService getPersonServiceImpl() {
        return personService;
    }

    public static StudentService getStudentServiceImpl() {
        return studentService;
    }

    public static TeacherService getTeacherServiceImpl() {
        return teacherService;
    }
}
