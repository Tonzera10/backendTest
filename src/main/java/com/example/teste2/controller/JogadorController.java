package com.example.teste2.controller;

import com.example.teste2.dto.JogadorDTO;
import com.example.teste2.entities.JogadorEntity;
import com.example.teste2.services.OrganizarTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private OrganizarTimesService organizarTimesService;

    @PostMapping
    public void criarJogador(@RequestBody JogadorDTO jogadorDTO) {
        organizarTimesService.criarJogador(jogadorDTO.getNome(), jogadorDTO.getSobrenome());
    }
}
