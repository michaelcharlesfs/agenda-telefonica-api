package br.com.michael.agendatelefonica.controller;

import br.com.michael.agendatelefonica.controller.dto.ContatoForm;
import br.com.michael.agendatelefonica.controller.dto.ContatoDto;
import br.com.michael.agendatelefonica.modelo.Contato;
import br.com.michael.agendatelefonica.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<Page<ContatoDto>> listarContatos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {
        Page<Contato> paginaContatos = contatoRepository.findAll(paginacao);
        return ResponseEntity.ok(ContatoDto.construir(paginaContatos));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ContatoDto> cadastrarContato(@RequestBody @Valid ContatoForm contatoForm,
                                                       UriComponentsBuilder uriComponentsBuilder) {
        Contato contato = contatoForm.atualizar();
        contatoRepository.save(contato);

        URI uri = uriComponentsBuilder.path("/contatos/{id}").buildAndExpand(contato.getId()).toUri();
        return ResponseEntity.created(uri).body(new ContatoDto(contato));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> encontrarContatoPorId(@PathVariable Long id) {
        Optional<Contato> optional = contatoRepository.findById(id);
        if (optional.isPresent()) {
            Contato contato = optional.get();
            return ResponseEntity.ok(new ContatoDto(contato));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ContatoDto> atualizarContato(@PathVariable Long id,
                                                       @RequestBody @Valid ContatoForm contatoForm) {
        Contato contato = contatoForm.atualizar(contatoRepository, id);
        if (contato != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
