package ir.hibernate.person;

import ir.hibernate.person.domain.*;
import ir.hibernate.person.util.ApplicationContex;
import ir.hibernate.person.validation.ValidationStudent;
import ir.hibernate.person.validation.ValidationTeacher;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, SAXException {


        Person person = new Person("Hosein", "Rezaei", "1377");
        Person person1 = new Person("Ali", "Ebrahimi", "1380");
        Person person2 = new Person("Mohsen", "Razavi", "1368");
        Person person3 = new Person("Hassan", "Bahrami", "1370");

        Student student = new Student(113845, "Mathematic");
        Student student1 = new Student(115421, "Physics");
        Student student2 = new Student(158237, "Electronic");
        Student student3 = new Student(198756, "chemistry");

        Teacher teacher = new Teacher("majid", "vaezzade", "1400", 150, Degree.DOCTORATE, MasterDegree.PROFESSOR, 12500000L);
        Teacher teacher1 = new Teacher("mehdi", "vaezzade", "1401", 160, Degree.MASTER, MasterDegree.PROFESSOR, 12700000L);
        Teacher teacher2 = new Teacher("mohsen", "vaezzade", "1400", 170, Degree.BACHELOR, MasterDegree.ASSOCIATEPROFESSOR, 102500000L);
        Teacher teacher3 = new Teacher("vahid", "vaezzade", "1399", 180, Degree.MASTER, MasterDegree.ASSISTANTPROFESSOR, 11500000L);
        Teacher teacher4 = new Teacher("vahid", "vaezzade", "1399", 200, Degree.BACHELOR, MasterDegree.ASSISTANTPROFESSOR, 18500000L);

        ApplicationContex.getPersonServiceImpl().save(person);
        ApplicationContex.getPersonServiceImpl().save(person1);
        ApplicationContex.getPersonServiceImpl().save(person2);
        ApplicationContex.getPersonServiceImpl().save(person3);


        ValidationTeacher.validationforSaveTeacher(teacher);
        ValidationTeacher.validationforSaveTeacher(teacher1);
        ValidationTeacher.validationforSaveTeacher(teacher2);
        ValidationTeacher.validationforSaveTeacher(teacher3);
        ValidationStudent.validationforSaveStudent(student);
        ValidationStudent.validationforSaveStudent(student1);
        ValidationStudent.validationforSaveStudent(student2);
        ValidationStudent.validationforSaveStudent(student3);


        ApplicationContex.getPersonServiceImpl().deleteById(1);
        ApplicationContex.getPersonServiceImpl().deleteById(7);

        System.out.println(ApplicationContex.getPersonServiceImpl().contains(3));
        System.out.println(ApplicationContex.getStudentServiceImpl().contains(2));

        ApplicationContex.getStudentServiceImpl().findAll().forEach(System.out::println);

        ApplicationContex.getPersonServiceImpl().update("Mohamad", "Razavian", 4);
        ApplicationContex.getPersonServiceImpl().update("Mohamad", "Razavian", 8);
        ApplicationContex.getPersonServiceImpl().update("Mohamad", "Razavian", 10);

        System.out.println(ApplicationContex.getPersonServiceImpl().signUp("Ali", "jamshidi"));
        System.out.println(ApplicationContex.getStudentServiceImpl().signUp(2100, "Mechanic"));
        System.out.println(ApplicationContex.getTeacherServiceImpl().signUp(500, Degree.MASTER));

        System.out.println(ApplicationContex.getPersonServiceImpl().findById(1));
        System.out.println(ApplicationContex.getStudentServiceImpl().findById(8));
        System.out.println(ApplicationContex.getTeacherServiceImpl().findById(10));

    }
}
