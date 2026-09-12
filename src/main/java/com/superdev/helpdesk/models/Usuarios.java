package com.superdev.helpdesk.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Table
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (length = 70,nullable = false,unique = true)
    private String nome;
    @Column (length = 200,nullable = false,unique = true)
    private String email;
    @Column (nullable = false)
    private Boolean ativo;
    @Column(name = "criado em",nullable = false,updatable = false)
    private LocalDateTime criadoEm;

    @PrePersist void aoCriar(){

        if (criadoEm ==null)
            criadoEm = LocalDateTime.now();

    }

}
