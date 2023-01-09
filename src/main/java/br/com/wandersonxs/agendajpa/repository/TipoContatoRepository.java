package br.com.wandersonxs.agendajpa.repository;

import br.com.wandersonxs.agendajpa.model.Pessoa;
import br.com.wandersonxs.agendajpa.model.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoContatoRepository extends JpaRepository<TipoContato, Long> {
}