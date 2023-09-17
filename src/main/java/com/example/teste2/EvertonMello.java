package com.example.teste2;

import java.util.*;

public class EvertonMello {

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

    public static void main(String[] args) {
        List<String> jogadores = Arrays.asList(
                "Lionel Messi", "Cristiano Ronaldo", "Neymar Jr.",
                "Kylian Mbappé", "Luka Modric", "Sergio Ramos",
                "Gareth Bale", "Gianluigi Buffon", "Gonzalo Higuain",
                "Thiago Silva", "Sergio Aguero", "Angel Di Maria",
                "Ton Messi", "Jeff Jr."
        );

        Map<String, List<String>> times = organizarTimes(jogadores);

        for (Map.Entry<String, List<String>> entry : times.entrySet()) {
            String letra = entry.getKey();
            List<String> time = entry.getValue();
            System.out.println("Time '" + letra + "': " + time);
        }
    }
}

