package com.superdev.helpdesk.services;

import com.superdev.helpdesk.dtos.ticket.*;
import com.superdev.helpdesk.enums.Papel;
import com.superdev.helpdesk.enums.Statusticket;
import com.superdev.helpdesk.exceptions.RegraNegocio;
import com.superdev.helpdesk.models.Ticket;
import com.superdev.helpdesk.models.Usuario;
import com.superdev.helpdesk.repositories.TicketRepository;
import jdk.jshell.Snippet;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    private final TicketRepository repository;
    private final UsuarioService usuarioService;
    private int id;
    private TicketDefinirPrioridadeDto dado;

    private TicketService(TicketRepository repository, UsuarioService usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    public List<Ticket> listar() {
        return repository.findAll();
    }

    private String gerarNumeroProtocolo(Ticket ticket) {
        String dataCriacao = ticket.getDataCriacao().format(DateTimeFormatter.BASIC_ISO_DATE);
        String numero = String.format("%05d", ticket.getId());
        return dataCriacao + "-" + numero;
    }


    public Ticket criar(TicketCriarDto dado) {
        Usuario usuario = usuarioService.obterPorId(dado.solicitanteId());
        if (usuario.getPapel() != Papel.SOLICITANTE) {

            throw new RegraNegocio("Tickets so pdem ser aberto po solicitantes");

        }

        String numeroProtocoloFake = UUID.randomUUID().toString().substring(0,20);

        Ticket ticket = Ticket.builder()
                .titulo(dado.titulo())
                .descricao(dado.descricao())
                .setor(dado.setor())
                .solicitante(usuario)
                .status(Statusticket.ABERTO)
                .numeroProtocolo(numeroProtocoloFake)
                .build();
      /*
      Executa o INSERT agora ,ainda dentro da transaçao(sem commit).o banvo gera o valor da coluna IDENTY
      e o hibernate  preenche o ticket.getid()
      * */
        repository.saveAndFlush(ticket);
        String numeroProtocolo=gerarNumeroProtocolo(ticket);
        ticket.setNumeroProtocolo(numeroProtocolo);
        return ticket;
    }
    public Ticket associar (int id, TicketAssociarDto dado){
        Ticket ticket= repository.findById(id).orElseThrow();
        Usuario usuario =usuarioService.obterPorId(dado.usuarioId());

        if (ticket.getStatus()!= Statusticket.ABERTO){
            throw new RegraNegocio("Tickets podem ser associados somente com o status aberto");
        }

        if(usuario.getPapel()!=Papel.ATENDENTE){
            throw new RegraNegocio("Tickets podem ser associados somente com o papel de atendente");
        }


                ticket.setAtendente(usuario);
                ticket.setStatus(Statusticket.EM_ANALISE);
        return repository.save(ticket);
    }
public Ticket cancelar(int id, TicketCancelarDto dado) {
    Ticket ticket = repository.findById(id).orElseThrow();

    if(ticket.getStatus()== Statusticket.CANCELADO){
        throw new RegraNegocio("Tickets não podem ser cancelados quando ja estao cancelados");
        }else if (ticket.getStatus()==Statusticket.RESOLVIDO){
            throw new RegraNegocio("Tickets nao podem ser cancelados quando ja estao resolvidos");

        }

        ticket.setStatus(Statusticket.CANCELADO);
        ticket.setMotivoCancelamento(dado.motivoCancelamento());
        return repository.save(ticket);

    }
    public Ticket resolver(int id, TicketResolverDto dado){
        Ticket ticket= repository.findById(id).orElseThrow();
        if (ticket.getStatus()!=Statusticket.EM_ANALISE){
            throw new RegraNegocio("Ticket não podem ser resolvido quando nao estiver em analise");

        } ticket.setStatus(Statusticket.RESOLVIDO);
        ticket.setDescricaoSolucao(dado.descricaoSolucao());
        return repository.save(ticket);

    } public Ticket definirPrioridade(int id, TicketDefinirPrioridadeDto dado){

        Ticket ticket= repository.findById(id).orElseThrow();
        if(ticket.getStatus()!=Statusticket.EM_ANALISE){
            throw new RegraNegocio("Ticket podem ser colocados em prioridade");

        }ticket.setPrioridade(dado.prioridade);

        return repository.save(ticket);

    }








                }


