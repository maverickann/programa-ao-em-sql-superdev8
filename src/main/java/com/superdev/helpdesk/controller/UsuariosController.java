package com.superdev.helpdesk.controller;

import com.superdev.helpdesk.dtos.usuarios.UsuariosCriarDto;
import com.superdev.helpdesk.models.Usuarios;
import com.superdev.helpdesk.services.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosService service;

    public UsuariosController(UsuariosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuarios> listar() {
        return this.service.listar();
    }

    @PostMapping
    public Usuarios criar(@RequestBody @Valid UsuariosCriarDto dto) {
        return this.service.criar(dto);
    }
}

