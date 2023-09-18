package com.example.teste2.util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrganizarTimesUtil {

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
}
