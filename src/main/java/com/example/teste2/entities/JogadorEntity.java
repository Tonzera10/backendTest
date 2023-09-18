package com.example.teste2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "jogador")
public class JogadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjogador", nullable = true)
    private Long id;

    @Column(name = "nomejogador", length = 50, nullable = true)
    private String nomeCompleto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_id")
    private TimesEntity time;

    public JogadorEntity(){
    }

    public JogadorEntity(String nome){
        this.nomeCompleto = nome;
    }
}
