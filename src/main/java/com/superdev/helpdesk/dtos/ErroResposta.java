package com.superdev.helpdesk.dtos;

import java.util.List;

public record ErroResposta() {
    String codigo,

    String mensagem,
    List<?> detalhes
}
