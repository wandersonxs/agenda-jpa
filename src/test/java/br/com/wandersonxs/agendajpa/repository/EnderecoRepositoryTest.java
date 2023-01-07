package br.com.wandersonxs.agendajpa.repository;

import br.com.wandersonxs.agendajpa.model.Endereco;
import br.com.wandersonxs.agendajpa.model.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnderecoRepositoryTest {

    @Autowired
    public EnderecoRepository enderecoRepository;


    @Test
    public void testFindAllEndereco(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        Assert.isTrue(enderecos.size() > 0, "Não encontrou endereços");
    }


    @Test
    public void testEnderecoTemPessoa(){
        List<Endereco> enderecos = enderecoRepository.findAll();
//        Pessoa pessoa = enderecos.get(0).getPessoas().get(0);
//        Assert.isTrue(pessoa != null, "Não encontrou pessoa");
    }

}
