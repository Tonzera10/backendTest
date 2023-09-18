package com.example.teste2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TimeComJogadoresDTO {

    private String nomeTime;
    private List<String> jogadores;
}
