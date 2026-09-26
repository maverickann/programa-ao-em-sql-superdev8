package com.superdev.helpdesk.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ErroResposta(   @Schema(example = "nao encontrado")
                              String odigo,
                              @Schema(example="categoria nao encontrada")
                              String mensagem,

                              List<?> detalhes) {

}
