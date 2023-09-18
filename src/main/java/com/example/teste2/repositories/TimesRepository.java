package com.example.teste2.repositories;

import com.example.teste2.entities.TimesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimesRepository extends JpaRepository<TimesEntity, Long> {

    Optional<TimesEntity> findByNome(String nome);
}
