package com.example.teste2.repositories;

import com.example.teste2.entities.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<JogadorEntity, String> {
}
