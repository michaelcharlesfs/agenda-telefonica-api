package br.com.michael.agendatelefonica.controller.dto;

import br.com.michael.agendatelefonica.modelo.Contato;
import org.springframework.data.domain.Page;

public class ContatoDto {

    private Long id;
    private String nome;
    private String telefone;

    public ContatoDto(Contato contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.telefone = contato.getTelefone();
    }

    public static Page<ContatoDto> construir(Page<Contato> paginaContatos) {
        return paginaContatos.map(ContatoDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
