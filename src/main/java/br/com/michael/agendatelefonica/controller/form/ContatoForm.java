package br.com.michael.agendatelefonica.controller.form;

import br.com.michael.agendatelefonica.modelo.Contato;
import br.com.michael.agendatelefonica.repository.ContatoRepository;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

public class ContatoForm {

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

    public Contato atualizar() {
        return new Contato(nome, telefone);
    }

    public Contato atualizar(ContatoRepository contatoRepository, Long id) {
        Optional<Contato> optional = contatoRepository.findById(id);
        if (optional.isPresent()) {
            Contato contato = optional.get();
            contato.setNome(nome);
            contato.setTelefone(telefone);
            contatoRepository.save(contato);
            return contato;
        } else {
            return null;
        }
    }
}
