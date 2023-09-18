package com.example.teste2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jogador")
public class JogadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String nomeCompleto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_id")
    private TimesEntity time;

}
