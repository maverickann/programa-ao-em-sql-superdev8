package com.superdev.helpdesk.services;


import com.superdev.helpdesk.dtos.categoria.CategoriaCriarDto;
import com.superdev.helpdesk.models.Categoria;
import com.superdev.helpdesk.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import  java.util.List;
@Service
public class CategoriasService {
    private final CategoriaRepository repository;
    public CategoriasService(CategoriaRepository repository){
        this.repository= repository;

    }
    public List<Categoria> listar(){
        return this.repository.findAll();
    }

    public Categoria criar (CategoriaCriarDto dado){
        var categoria= Categoria.builder()
                .nome(dado.nome())
                .descricao(dado.descricao())
                .ativa(true)
                .build();
        return this.repository.save(categoria);

    }
    public Categoria atualizar (int id,CategoriaCriarDto dado){
        var categoria= repository.findById(id)
                .orElseThrow();
              categoria.setNome(dado.nome());
        categoria.setDescricao(dado.descricao());

        return this.repository.save(categoria);

    }
    public Categoria apagar (int id){
        var categoria= repository.findById(id)
                .orElseThrow();
    categoria.setAtiva(false);
        return this.repository.save(categoria);

}}
