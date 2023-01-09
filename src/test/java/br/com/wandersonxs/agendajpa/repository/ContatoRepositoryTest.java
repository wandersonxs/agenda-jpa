package br.com.wandersonxs.agendajpa.repository;

import br.com.wandersonxs.agendajpa.model.Contato;
import br.com.wandersonxs.agendajpa.model.Pessoa;
import br.com.wandersonxs.agendajpa.model.TipoContato;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContatoRepositoryTest {

    @Autowired
    public PessoaRepository pessoaRepository;


    @Autowired
    public TipoContatoRepository tipoContatoRepository;

    @Autowired
    public ContatoRepository contatoRepository;


    @Test
    public void testIncluirContato(){

        // GIVEN Objeto Pessoa com endereco e dados corretos
        Optional<TipoContato> tipoContato = tipoContatoRepository.findById(2L);
        Optional<Pessoa> pessoa = pessoaRepository.findById(3L);


        Contato contato = Contato.builder()
                .pessoa(pessoa.get())
                .tipoContato(tipoContato.get())
                .valor("4599998093")
                .build();

        // WHEN Executar a inserção no banco
        Contato contatoDb = contatoRepository.save(contato);

        // THEN Pessoa deve ser cadastrada com sucesso no banco
        Assert.isTrue(contatoDb.getId() != null, "Erro ao incluir contato");
    }



}
