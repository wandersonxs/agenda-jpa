package br.com.wandersonxs.agendajpa.repository;

import br.com.wandersonxs.agendajpa.model.Endereco;
import br.com.wandersonxs.agendajpa.model.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoaRepositoryTest {

    @Autowired
    public PessoaRepository pessoaRepository;

    @Autowired
    public EnderecoRepository enderecoRepository;


    @Test
    public void testIncluirNovaPessoaComEnderecoExistente(){

        // GIVEN Objeto Pessoa com endereco e dados corretos
        Optional<Endereco> endereco = enderecoRepository.findById(1L);
        Pessoa pessoa = Pessoa.builder()
                .nome("Caroline")
                .endereco(endereco.get())
                .build();

        // WHEN Executar a inserção no banco
        Pessoa pessoaSalvaDb = pessoaRepository.save(pessoa);

        // THEN Pessoa deve ser cadastrada com sucesso no banco
        Assert.isTrue(pessoaSalvaDb.getId() != null, "Erro ao incluir pessoa");
    }

    @Test
    public void testAtualizarNovaPessoaComEnderecoExistente(){

        String nomeAlterado = "Stephany Xesquevixos";
        // GIVEN Objeto Pessoa com endereco e dados corretos
        Optional<Endereco> endereco = enderecoRepository.findById(1L);
        Optional<Pessoa> pessoa = pessoaRepository.findById(3L);

        // WHEN Executar a atualização no banco com nome diferente
        pessoa.get().setNome(nomeAlterado);
        Pessoa pessoaSalvaDb = pessoaRepository.save(pessoa.get());

        // THEN Pessoa deve ser atualizada com sucesso no banco
        Assert.isTrue(pessoaSalvaDb.getNome().equals(nomeAlterado), "Erro ao incluir pessoa");
    }

    @Test
    public void testIncluirNovaPessoaComEnderecoInexistente(){

        // GIVEN Objeto Pessoa com um novo endereco (Sem ID) e dados corretos
        Endereco endereco = Endereco.builder()
                .logradouro("Rua Nova Esperança")
                .cidade("São José dos Campos")
                .build();
        Pessoa pessoa = Pessoa.builder()
                .nome("Roberval")
                .endereco(endereco)
                .build();

        // WHEN Executar a inserção no banco
        Pessoa pessoaSalvaDb = pessoaRepository.save(pessoa);

        // THEN Deve Incluir Pessoa e Também Endereço
        Assert.isTrue(pessoaSalvaDb.getEndereco().getId() != null, "Erro ao incluir pessoa");
    }


    @Test
    public void testRemoverPessoaExcluindoEnderecoTambem(){

        // GIVEN Objeto Pessoa
        Optional<Pessoa> pessoa = pessoaRepository.findById(4L);
        Optional<Endereco> endereco = enderecoRepository.findById(1L);

        // WHEN Executar a inserção no banco
        pessoaRepository.delete(pessoa.get());

        pessoa = pessoaRepository.findById(8L);
        endereco = enderecoRepository.findById(1L);

        // THEN Deve Incluir Pessoa e Também Endereço
        Assert.isTrue(pessoa.isPresent() == false && endereco.isPresent() == true, "Erro ao delete pessoa");
    }



}
