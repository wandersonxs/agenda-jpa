package br.com.wandersonxs.agendajpa.repository;

import br.com.wandersonxs.agendajpa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}