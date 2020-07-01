package br.com.michael.agendatelefonica.controller;

import br.com.michael.agendatelefonica.config.auth.TokenService;
import br.com.michael.agendatelefonica.controller.dto.TokenDto;
import br.com.michael.agendatelefonica.controller.form.LoginForm;
import br.com.michael.agendatelefonica.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> obterTokenDeAutorizacao(@RequestBody @Valid LoginForm loginForm) {
        UsernamePasswordAuthenticationToken dadosParaAutenticar = loginForm.converter();
        try {
            Authentication dadosAutenticacao = authenticationManager.authenticate(dadosParaAutenticar);
            Usuario usuario = (Usuario) dadosAutenticacao.getPrincipal();
            String token = tokenService.gerarToken(usuario.getId());
            return ResponseEntity.ok(new TokenDto(token, "Bearer "));
        } catch (AuthenticationException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

}
