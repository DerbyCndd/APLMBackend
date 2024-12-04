package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public record UserUpdateDto(
        @NotNull String id,
        int pontos,
        String localizacao
) {}
