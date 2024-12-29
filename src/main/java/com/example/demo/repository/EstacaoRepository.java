package com.example.demo.repository;

import com.example.demo.domain.estacao.Estacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacaoRepository extends JpaRepository<Estacao, String> {
}
