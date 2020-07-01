package br.com.michael.agendatelefonica.repository;

import br.com.michael.agendatelefonica.modelo.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
