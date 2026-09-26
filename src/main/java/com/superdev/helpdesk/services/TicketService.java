package com.superdev.helpdesk.services;

import com.superdev.helpdesk.dtos.ticket.TicketCriarDto;
import com.superdev.helpdesk.models.Ticket;
import com.superdev.helpdesk.models.Usuario;
import com.superdev.helpdesk.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketService {
    private final TicketRepository repository;
    private final UsuarioService  usuarioService;
    private TicketService(TicketRepository repository, UsuarioService usuarioService){this.repository=repository;
        this.usuarioService = usuarioService;
    }
    public List<Ticket>listar()
    {return repository.findAll();
    }

public Ticket criar(TicketCriarDto dado){
        Usuario usuario = usuarioService.obterPorId(dado.solicitanteId());
                Ticket ticket=Ticket.builder()
                        .titulo(dado.titulo())
                        .descricao(dado.descricao())
                        .setor(dado.setor())
                        .solicitante(usuario)
                        .status(statusTicket.ABERTO)
                        .numeroProtocolo("20260925-00001")
                        .build();
        return repository.save(ticket);
}


}
