package br.com.wandersonxs.agendajpa.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cidade;

    @OneToMany(mappedBy = "endereco", fetch = FetchType.EAGER)
    private List<Pessoa> pessoas;

//    @OneToOne(mappedBy = "endereco")
//    private Pessoa pessoa;
}
