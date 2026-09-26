package com.superdev.helpdesk.dtos.ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TicketResolverDto(
        @NotBlank @Size(min = 20,max = 5000)
        String descricaoSolucao
) {
}
