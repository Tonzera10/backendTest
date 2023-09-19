package com.example.teste2.controller;

import com.example.teste2.dto.JogadorDTO;
import com.example.teste2.entities.TimesEntity;
import com.example.teste2.services.OrganizarTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
//@CrossOrigin(origins = {"http://localhost:4200"})
public class OrganizarTimesController {

    @Autowired
    private OrganizarTimesService organizarTimesService;


    @PostMapping("/jogador")
    public void criarJogador(@RequestBody JogadorDTO jogador) {
        OrganizarTimesService.criarJogador(jogador);
    }

//    @GetMapping("/times")
//    public List<TimesEntity> obterTimes() {
//        return organizarTimesService.obterTimes();
//    }

//    @DeleteMapping("/jogador/all")
//    public void limparJogadores() {
//        organizarTimesService.limparJogadores();
//    }
}
