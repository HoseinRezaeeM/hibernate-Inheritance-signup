package reposiorytest;

import ir.hibernate.person.domain.Person;
import ir.hibernate.person.util.ApplicationContex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BaseEntityRepositoryImplTest {

    @Test
    void saveTest() {
        Person person = new Person("Hosein", "Rezaei", "1377/02/07");
        ApplicationContex.getPersonServiceImpl().save(person);
        final boolean contains = ApplicationContex.getPersonServiceImpl().contains(1);
        Assertions.assertTrue(contains);
    }

    @Test
    void updateTest() {
        Person person = ApplicationContex.getPersonServiceImpl().findById(2);
        ApplicationContex.getPersonServiceImpl().update("zahra", "Ebrahi", 2);
        Person person1 = ApplicationContex.getPersonServiceImpl().findById(2);
        Assertions.assertNotEquals(person1,person);
    }

    @Test
    void deleteByIdTest() {
        ApplicationContex.getPersonServiceImpl().deleteById(3);
        Person person = ApplicationContex.getPersonServiceImpl().findById(3);
        Assertions.assertNull(person);

    }

    @Test
    void findAllTest() {
        final List<Person> all = ApplicationContex.getPersonServiceImpl().findAll();
        Assertions.assertNotNull(all);
    }

    @Test
    void containsTest() {
        ApplicationContex.getPersonServiceImpl().deleteById(5);
        final boolean contains = ApplicationContex.getPersonServiceImpl().contains(5);
        Assertions.assertFalse(contains);
    }
}