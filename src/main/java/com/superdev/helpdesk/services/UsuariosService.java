package com.superdev.helpdesk.services;

import com.superdev.helpdesk.dtos.usuarios.UsuariosCriarDto;
import com.superdev.helpdesk.models.Usuarios;
import com.superdev.helpdesk.repositories.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

    private final UsuariosRepository repository;

    public UsuariosService(UsuariosRepository repository) {
        this.repository = repository;
    }

    public List<Usuarios> listar() {
        return repository.findAll();
    }

    public Usuarios criar(UsuariosCriarDto dado) {
        var usuario = Usuarios.builder()
                .nome(dado.nome())
                .email(dado.email())
                .ativo(true)
                .build();

        return repository.save(usuario);
    }
}
