package ir.hibernate.person.validation;

import ir.hibernate.person.domain.Student;
import ir.hibernate.person.util.ApplicationContex;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

public class ValidationStudent {
//Hosen Rezaei https://www.linkedin.com/in/hosein-rezaei-developer

    public static void validationforSaveStudent(Student student) throws IOException, SAXException {
        ValidatorFactory factory;
        factory=Validation.byDefaultProvider().configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator;
        validator=factory.usingContext()
                .messageInterpolator(new ParameterMessageInterpolator())
                .getValidator();

        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if (violations.isEmpty()) {
            ApplicationContex.getStudentServiceImpl().save(student);
            System.out.println("Teacher saved successfully.");
        } else {
            for (ConstraintViolation<Student> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("Teacher validation failed. Not saving to the database.");
        }

        factory.close();
    }
}
