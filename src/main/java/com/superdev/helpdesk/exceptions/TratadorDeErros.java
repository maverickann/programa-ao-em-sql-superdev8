package com.superdev.helpdesk.exceptions;

import com.superdev.helpdesk.dtos.ErroResposta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class TratadorDeErros {
@ExceptionHandler(ErroAplicacao.class)
public  ResponseEntity <ErroResposta>tratarErroAplicacao(ErroAplicacao){
    return ResponseEntity
            .status((Exception.getStatus))
            .body(new ErroResposta(exception.getCodigo(),exception))
}
}
