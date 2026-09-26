package com.superdev.helpdesk.controllers;

import com.superdev.helpdesk.dtos.ticket.*;
import com.superdev.helpdesk.models.Ticket;
import com.superdev.helpdesk.services.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/tickets")
@Tag(name="Tickets")

public class TicketController
{
    private final TicketService service;

    public TicketController(TicketService service){
        this.service=service;

    }
    @GetMapping
    public List<Ticket>listar(){
        return service.listar();
    }
@PostMapping
    public Ticket criar(@RequestBody @Valid TicketCriarDto dado){
        return service.criar(dado);


}
    @PostMapping( "/{id}/associar")
    @Operation(summary = "associar o ticket ao")
    public Ticket associar (@PathVariable int id,@RequestBody @Valid TicketAssociarDto dado){

        return service.associar(id,dado);
    }
    @PostMapping ("/{id}/cancelar")
    @Operation(summary = "cancelarticket em  aberto")
        public Ticket cancelar (@PathVariable int id,@RequestBody @Valid TicketCancelarDto dado){
        return service.cancelar(id,dado)     ;}

@PostMapping ("/{id}/resolver")
    @Operation(summary = "resolver o ticket em  aberto")
        public Ticket resolver (@PathVariable int id,@RequestBody @Valid TicketResolverDto dado){
        return service.resolver(id,dado)     ;}


        @PostMapping("/{id}/definir-prioridade")
    @Operation(summary = "definir prioridade")
    public  Ticket definirPrioridade(@PathVariable int id, @RequestBody @Valid TicketDefinirPrioridadeDto dado){
        return service.definirPrioridade(id,dado);
        }

}
