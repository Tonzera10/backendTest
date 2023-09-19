package com.example.teste2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "jogador")
public class JogadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "nome", length = 50, nullable = true)
    private String nome;

    @Column(name = "sobrenome", length = 50, nullable = true)
    private String sobrenome;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_id")
    private TimesEntity time;

}
