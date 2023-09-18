package com.example.teste2.repositories;

import com.example.teste2.entities.JogadorEntity;
import com.example.teste2.entities.TimesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JogadorRepository extends JpaRepository<JogadorEntity, Long> {

    List<JogadorEntity> findByTime(TimesEntity time);
}
