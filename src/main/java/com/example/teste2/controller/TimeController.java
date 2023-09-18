package com.example.teste2.controller;

import com.example.teste2.dto.TimeComJogadoresDTO;
import com.example.teste2.services.OrganizarTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private OrganizarTimesService organizarTimesService;

    @GetMapping
    public ResponseEntity<List<TimeComJogadoresDTO>> listarTimesComJogadores() {
        List<TimeComJogadoresDTO> timesComJogadores = organizarTimesService.listarTimesComJogadores();
        return ResponseEntity.ok(timesComJogadores);
    }
}
