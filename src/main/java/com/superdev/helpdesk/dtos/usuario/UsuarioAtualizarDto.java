package com.superdev.helpdesk.dtos.usuario;

import com.superdev.helpdesk.enums.Papel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioAtualizarDto(
        @NotBlank @Size (min=2 ,max=60)
        String nome,

        @NotBlank @Email  @Size (max=100)
        String email,
        @Schema(description="Define o papel do usuario:SOLICITANTE OU ATENDENTE",example="solicitante")
        Papel papel
) {
}