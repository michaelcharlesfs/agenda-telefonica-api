package br.com.michael.agendatelefonica.controller;

import br.com.michael.agendatelefonica.controller.dto.ContatoDto;
import br.com.michael.agendatelefonica.modelo.Contato;
import br.com.michael.agendatelefonica.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<?> listarContatos(Pageable paginacao) {
        Page<Contato> paginaContatos = contatoRepository.findAll(paginacao);
        return ResponseEntity.ok(ContatoDto.construir(paginaContatos));
    }

}
