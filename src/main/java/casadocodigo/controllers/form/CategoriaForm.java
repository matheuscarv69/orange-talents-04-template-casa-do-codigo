package casadocodigo.controllers.form;

import casadocodigo.configs.validation.customValidation.categoria.CategoriaDuplicada;
import casadocodigo.entities.Categoria;

import javax.validation.constraints.NotEmpty;

public class CategoriaForm {

    @NotEmpty
    @CategoriaDuplicada
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
