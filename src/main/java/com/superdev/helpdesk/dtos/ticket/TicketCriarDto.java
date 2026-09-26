package com.superdev.helpdesk.dtos.ticket;

import com.superdev.helpdesk.enums.Setor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TicketCriarDto(
    @Schema(example = "nao consigo acessar a vpn")
            @NotBlank
            @Size(min=12,max=120)
    String titulo,

    @Schema(example = "Desde ontem a vpm retorna ao erro de autenticaçao ao conectar de casa")
    @NotBlank
    @Size(min=10,max=5000)

    String descricao,
    @Schema(description = "define o setor:TI/RH/FINACEIRO/ADMINISTRATIVO/MANUTENCAO", example = "ti")
    @NotBlank

    Setor setor,
    @Schema(example = "id do usuario para abrir o ticket")
    @NotBlank


    Integer solicitanteId
){
}
