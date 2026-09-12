package com.superdev.helpdesk.dtos.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//record interage somente com o parenteses

public record UsuariosCriarDto (
    @NotBlank @Size (min=2 ,max=60)
    String nome,

    @NotBlank @Email  @Size (max=100)
    String email
    ){}



