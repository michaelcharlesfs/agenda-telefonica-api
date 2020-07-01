package br.com.michael.agendatelefonica.config.auth;

import br.com.michael.agendatelefonica.modelo.Usuario;
import br.com.michael.agendatelefonica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String usuarioLogin) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUsuario(usuarioLogin);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new UsernameNotFoundException("Dados inválidos!");
        }
    }
}
