package casadocodigo.configs.validation.customValidation.email;

import casadocodigo.entities.Autor;
import casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EmailDuplicadoValidator implements ConstraintValidator<EmailDuplicado, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(EmailDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        Optional<Autor> autor = autorRepository.findByEmail(email);
        if (autor.isPresent()) {
            return false;
        }

        return true;
    }
}
