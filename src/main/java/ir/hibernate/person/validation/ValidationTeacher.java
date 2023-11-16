package ir.hibernate.person.validation;

import ir.hibernate.person.domain.Teacher;
import ir.hibernate.person.util.ApplicationContex;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

public class ValidationTeacher {

    public static void validationforSaveTeacher(Teacher teacher) throws IOException, SAXException {
        ValidatorFactory factory;
        factory=Validation.byDefaultProvider().configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator ;
        validator=factory.usingContext()
                .messageInterpolator(new ParameterMessageInterpolator())
                .getValidator();
//Hosen Rezaei
        Set<ConstraintViolation<Teacher>> violations = validator.validate(teacher);

        if (violations.isEmpty()) {
            ApplicationContex.getTeacherServiceImpl().save(teacher);
            System.out.println("Teacher saved successfully.");
        } else {
            for (ConstraintViolation<Teacher> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("Teacher validation failed. Not saving to the database.");
        }

        factory.close();
    }
}

