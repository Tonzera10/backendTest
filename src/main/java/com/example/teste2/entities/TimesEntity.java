package com.example.teste2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "times")
public class TimesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "nome", length = 50, nullable = true)
    private String nome;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    public List<JogadorEntity> jogadores = Arrays.asList();

}
