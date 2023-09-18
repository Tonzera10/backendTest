package com.example.teste2.services;

import com.example.teste2.entities.JogadorEntity;
import com.example.teste2.repositories.JogadorRepository;
import com.example.teste2.repositories.TimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrganizarTimesService {
    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private TimesRepository timeRepository;

    public Map<String, List<String>> times = new HashMap<>();

    public void organizarTimes(String jogador) {
        String[] nomeSobrenome = jogador.split(" ");
        String sobrenome = nomeSobrenome[nomeSobrenome.length - 1];
        String primeiraLetraSobrenome = sobrenome.substring(0, 1);
        String chaveTimeAlternativo = "T" + (times.size() + 1);

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
        JogadorEntity nomeJogador = new JogadorEntity(jogador);
        jogadorRepository.save(nomeJogador);

    }

    public void limparJogadores() {
        jogadorRepository.deleteAll();
        times.clear();
    }
}


//    public void criarJogador(String nome, String sobrenome) {
//        String primeiraLetraSobrenome = sobrenome.substring(0, 1);
//
//        // Verifique se o time já existe para a primeira letra do sobrenome
//        Optional<TimesEntity> optionalTime = timeRepository.findByNome(primeiraLetraSobrenome);
//
//        TimesEntity time;
//        if (optionalTime.isPresent()) {
//            time = optionalTime.get();
//        } else {
//            time = new TimesEntity();
//            time.setNome(primeiraLetraSobrenome);
//        }
//
//        // Crie o jogador e adicione ao time
//        JogadorEntity jogador = new JogadorEntity();
//        jogador.setNome(nome);
//        jogador.setSobrenome(sobrenome);
//        jogador.setTime(time);
//
//        jogadorRepository.save(jogador);
//        timeRepository.save(time);
//
//    }

//    public List<TimeComJogadoresDTO> listarTimesComJogadores() {
//        List<TimeComJogadoresDTO> timesComJogadores = new ArrayList<>();
//
//        List<TimesEntity> times = timeRepository.findAll();
//        for (TimesEntity time : times) {
//            TimeComJogadoresDTO dto = new TimeComJogadoresDTO();
//            dto.setNomeTime(time.getNome());
//
//            List<JogadorEntity> jogadores = jogadorRepository.findByTime(time);
//            List<String> nomesJogadores = jogadores.stream()
//                    .map(JogadorEntity::getNome)
//                    .collect(Collectors.toList());
//
//            dto.setJogadores(nomesJogadores);
//            timesComJogadores.add(dto);
//        }
//
//        return timesComJogadores;
//    }
//}
