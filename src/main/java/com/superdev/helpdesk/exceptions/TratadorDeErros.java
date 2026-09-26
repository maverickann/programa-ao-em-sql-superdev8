package com.superdev.helpdesk.exceptions;

import com.superdev.helpdesk.dtos.ErroResposta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

@ExceptionHandler(ErroAplicacao.class)
public  ResponseEntity <ErroResposta>tratarErroAplicacao(ErroAplicacao  exception){
    return ResponseEntity
            .status(exception.getStatus())
            .body(new ErroResposta(exception.getCodigo(),exception.getMessage(), List.of()));
}
}
