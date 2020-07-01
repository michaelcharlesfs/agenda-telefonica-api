package br.com.michael.agendatelefonica.controller;

import br.com.michael.agendatelefonica.controller.dto.CadastroContatoDto;
import br.com.michael.agendatelefonica.controller.dto.ContatoDto;
import br.com.michael.agendatelefonica.modelo.Contato;
import br.com.michael.agendatelefonica.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<Page<ContatoDto>> listarContatos(Pageable paginacao) {
        Page<Contato> paginaContatos = contatoRepository.findAll(paginacao);
        return ResponseEntity.ok(ContatoDto.construir(paginaContatos));
    }

    @PostMapping
    public ResponseEntity<ContatoDto> cadastrarContato(@RequestBody @Valid CadastroContatoDto cadastroContatoDto,
                                                       UriComponentsBuilder uriComponentsBuilder) {
        Contato contato = cadastroContatoDto.converter();
        contatoRepository.save(contato);

        URI uri = uriComponentsBuilder.path("/contatos/{id}").buildAndExpand(contato.getId()).toUri();
        return ResponseEntity.created(uri).body(new ContatoDto(contato));
    }

}
