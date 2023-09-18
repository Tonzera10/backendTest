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
    public void adicionarJogador(@RequestBody String jogador) {
        organizarTimesService.organizarTimes(jogador);
    }

    @GetMapping("/times")
    public Map<String, List<String>> obterTimes() {
        return organizarTimesService.times;
    }

    @DeleteMapping("/jogador/all")
    public void limparJogadores() {
        organizarTimesService.limparJogadores();
    }
}
