package com.example.teste2.services;

import com.example.teste2.dto.JogadorDTO;
import com.example.teste2.entities.JogadorEntity;
import com.example.teste2.entities.TimesEntity;
import com.example.teste2.repositories.JogadorRepository;
import com.example.teste2.repositories.TimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrganizarTimesService {

    @Autowired
    static TimesRepository timesRepository;
    @Autowired
    JogadorRepository jogadorRepository;

    public static List<JogadorDTO> jogadores = new ArrayList<>();

    public static void criarJogador(JogadorDTO jogador) {
        jogadores.add(jogador);
    };

    public static Map<String, List<String>> organizarTimes(List<String> jogadores) {
        Map<String, List<String>> times = new HashMap<>();

        for (String jogador : jogadores) {
            String[] nomeSobrenome = jogador.split(" ");
            String sobrenome = nomeSobrenome[nomeSobrenome.length - 1];
            String primeiraLetraSobrenome = sobrenome.substring(0, 1);
            String chaveTimeAlternativo = "T" + times.size() +1;

            if (!times.containsKey(primeiraLetraSobrenome)) {
                times.put(primeiraLetraSobrenome, new ArrayList<>());
            }

            List<String> time = times.get(primeiraLetraSobrenome);

            boolean jogadorRepetido = false;
            for (String jogadorTime : time) {
                String sobrenomeTime = jogadorTime.split(" ")[1];
                if (sobrenomeTime.equals(sobrenome)) {
                    jogadorRepetido = true;
                    times.put(chaveTimeAlternativo, new ArrayList<>());
                    break;
                }
            }

            List<String> timeAlternativo = times.get(chaveTimeAlternativo);

            if (!jogadorRepetido) {
                time.add(jogador);
            } else {
                timeAlternativo.add(jogador);
            }
        }

        return times;
    }
};



