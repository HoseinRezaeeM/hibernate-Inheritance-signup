package ir.hibernate.person.util;

import ir.hibernate.person.domain.Person;
import ir.hibernate.person.domain.Student;
import ir.hibernate.person.domain.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryProvider {

    private final static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(standardServiceRegistry)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
