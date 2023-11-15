package reposiorytest;

import ir.hibernate.person.domain.Person;
import ir.hibernate.person.util.ApplicationContex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

class BaseEntityRepositoryImplTest {

    @Test
    void saveTest() throws IOException, SAXException {
        Person person = new Person("Hosein", "Rezaei", "1377");
        ApplicationContex.getPersonServiceImpl().save(person);
        final boolean contains = ApplicationContex.getPersonServiceImpl().contains(1);
        Assertions.assertTrue(contains);
    }

    @Test
    void updateTest() {
        Person person = new Person();
        person.setFirstname("Fatemeh");
        person.setLastname("saravin");
        ApplicationContex.getPersonServiceImpl().update("Fatemeh", "saravin", 2);
        Person person1 = ApplicationContex.getPersonServiceImpl().findById(2);
        Assertions.assertEquals(person.getFirstname(), person1.getFirstname());
        Assertions.assertEquals(person.getLastname(), person1.getLastname());
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