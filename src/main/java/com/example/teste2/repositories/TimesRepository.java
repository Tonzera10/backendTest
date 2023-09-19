package com.example.teste2.repositories;

import com.example.teste2.entities.TimesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesRepository extends JpaRepository<TimesEntity, Long> {

    TimesEntity findByNome(String nome);
}
