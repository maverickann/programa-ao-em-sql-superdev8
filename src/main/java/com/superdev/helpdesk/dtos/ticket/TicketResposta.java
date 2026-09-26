package com.superdev.helpdesk.dtos.ticket;

import com.superdev.helpdesk.enums.Prioridade;
import com.superdev.helpdesk.enums.Statusticket;
import com.superdev.helpdesk.models.Usuario;

import java.time.LocalDateTime;

public record TicketResposta(
        Integer id,
        String titulo,
        String descricao,
        Statusticket status,
        Prioridade prioridade ,
        Usuario solicitante,
        Usuario atendente,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
                               ) {




}
