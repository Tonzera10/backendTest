package com.example.teste2.controller;

import com.example.teste2.services.OrganizarTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class OrganizarTimesController {

    @Autowired
    private OrganizarTimesService organizarTimesService;


    @PostMapping("/jogador")
    public void criarJogador(@RequestBody String jogador) {
        organizarTimesService.criarJogador(jogador);
    }

    @GetMapping("/times")
    public Map<String, List<String>> obterTimes() {
        List<String> jogadores = organizarTimesService.getJogadores();
        return organizarTimesService.organizarTimes(jogadores);
    }

    @DeleteMapping("/jogador/all")
    public void limparJogadores() {
        organizarTimesService.limparJogadores();
    }
}
