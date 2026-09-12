package com.superdev.helpdesk.models;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Table  (name="categorias")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder


public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (length = 60,nullable = false,unique =true)
    private String nome;
    @Column(length = 255)
    private String descricao;
    @Column(nullable = false)
    private Boolean ativa;
    @Column(name = "criado em",nullable = false,updatable = false)
    private LocalDateTime criadoEm;

    @PrePersist void aoCriar(){

        if (criadoEm ==null)
            criadoEm = LocalDateTime.now();

    }

}
