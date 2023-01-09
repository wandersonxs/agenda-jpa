package br.com.wandersonxs.agendajpa.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER)
    private List<Contato> contatos;

 //    @OneToOne
//    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
//    private Endereco endereco;

}
