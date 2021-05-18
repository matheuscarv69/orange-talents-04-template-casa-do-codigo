package casadocodigo.configs.validation.customValidation.categoria;

import casadocodigo.entities.Autor;
import casadocodigo.entities.Categoria;
import casadocodigo.repositories.AutorRepository;
import casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CategoriaDuplicadaValidator implements ConstraintValidator<CategoriaDuplicada, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(CategoriaDuplicada constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {

        Optional<Categoria> categoria = categoriaRepository.findByNome(nome);
        if (categoria.isPresent()) {
            return false;
        }

        return true;
    }
}
