package br.com.wandersonxs.agendajpa.repository;

import br.com.wandersonxs.agendajpa.model.Contato;
import br.com.wandersonxs.agendajpa.model.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}