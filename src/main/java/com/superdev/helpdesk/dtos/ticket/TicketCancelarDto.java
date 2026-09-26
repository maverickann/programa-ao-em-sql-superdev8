package com.superdev.helpdesk.dtos.ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TicketCancelarDto(
        @NotBlank @Size(min = 10,max=1000)
        String motivoCancelamento
) {
}
