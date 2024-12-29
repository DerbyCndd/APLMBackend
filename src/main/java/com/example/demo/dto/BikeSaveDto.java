package com.example.demo.dto;

import com.example.demo.domain.estacao.Estacao;

public record BikeSaveDto(Estacao estacao,
                          String localizacao,
                          String referencia,
                          boolean estado) {
}
