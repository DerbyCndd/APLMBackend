package com.example.demo.dto;

public record UserSaveDto(
        String nome,
        int pontos,
        String localizacao,
        String senha) {
}
