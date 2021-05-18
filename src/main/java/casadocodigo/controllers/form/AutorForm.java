package casadocodigo.controllers.form;

import casadocodigo.configs.validation.customValidation.email.EmailDuplicado;
import casadocodigo.entities.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AutorForm {

    @NotEmpty
    private String nome;

    @NotEmpty
    @Email
    @EmailDuplicado
    private String email;

    @NotEmpty
    @Length(max = 400)
    private String descricao;

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter(){
        Autor autor = new Autor(this.nome, this.email, this.descricao);
        return autor;
    }

}
