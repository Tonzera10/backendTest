package com.example.teste2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "times")
public class TimesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtimes", nullable = true)
    private Long id;

    @Column(name = "nometimes", length = 50, nullable = true)
    private String nome;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<JogadorEntity> jogadores = new ArrayList<>();
}
