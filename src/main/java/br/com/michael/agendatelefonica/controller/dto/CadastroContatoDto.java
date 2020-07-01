package br.com.michael.agendatelefonica.controller.dto;

import br.com.michael.agendatelefonica.modelo.Contato;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CadastroContatoDto {

    @NotNull @NotEmpty @Length(max = 255)
    private String nome;
    @NotNull @NotEmpty
    private String telefone;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Contato converter() {
        return new Contato(nome, telefone);
    }
}
