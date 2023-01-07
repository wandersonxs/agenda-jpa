package br.com.wandersonxs.agendajpa.repository;

import br.com.wandersonxs.agendajpa.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}