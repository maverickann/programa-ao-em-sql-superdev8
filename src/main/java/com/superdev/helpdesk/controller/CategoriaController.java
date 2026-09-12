package com.superdev.helpdesk.controller;

import com.superdev.helpdesk.dtos.categoria.CategoriaCriarDto;
import com.superdev.helpdesk.models.Categoria;
import com.superdev.helpdesk.services.CategoriasService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriasService service;

    public CategoriaController(CategoriasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> listar() {
        return this.service.listar();
    }

    @PostMapping
    public Categoria criar(@RequestBody @Valid CategoriaCriarDto dto) {
        return this.service.criar(dto);
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable int id, @RequestBody @Valid CategoriaCriarDto dto) {
        return service.atualizar(id, dto);
    }


    @DeleteMapping("/{id}")
    public Categoria apagar (@PathVariable int id ){
        return service.apagar(id);
    }
}
