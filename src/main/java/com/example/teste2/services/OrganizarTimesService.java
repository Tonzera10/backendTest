package com.example.teste2.services;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrganizarTimesService {

    public List<String> jogadoresLista = new ArrayList<>();

    public  void criarJogador(String jogador) {
        jogadoresLista.add(jogador);
    };

    public List<String> getJogadores() {
        return jogadoresLista;
    }

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
                time.add(formataNome(jogador));
            } else {
                timeAlternativo.add(formataNome(jogador));
            }
        }
        return times;
    }

    public void limparJogadores(){
        jogadoresLista.clear();
    }

    public static String formataNome(String nome) {
        int start = nome.indexOf("\"nome\": \"") + 9; // Início do nome
        int end = nome.lastIndexOf("\""); // Fim da string

        if (start != -1 && end != -1 && start < end) {
            String nomeSobrenome = nome.substring(start, end);
            System.out.println("Nome e sobrenome: " + nomeSobrenome);
            return nomeSobrenome;
        } else {
            System.out.println("Não foi possível extrair o nome e sobrenome.");
        }
        return null;
    }
};



