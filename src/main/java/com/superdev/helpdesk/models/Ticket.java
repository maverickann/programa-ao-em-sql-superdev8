package com.superdev.helpdesk.models;

import com.superdev.helpdesk.enums.Prioridade;
import com.superdev.helpdesk.enums.Setor;
import com.superdev.helpdesk.enums.Statusticket;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name="tickets")
@NoArgsConstructor
@AllArgsConstructor

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (length = 120,nullable = false)
    private String titulo;

    @Column (name="numero_protocolo",length = 120,nullable = false,unique = true)
    private String numeroProtocolo;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String descricao;

    @Column(name="descricao_solucao",columnDefinition = "TEXT",nullable = false)
    private String descricaoSolucao;

    @Enumerated(EnumType.STRING)
    @Column(name="status_ticket",length=20,nullable = true)
    private Statusticket status;
    @Enumerated(EnumType.STRING)
    @Column(length=20,nullable = true)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(length=20,nullable = false)
    private Setor setor;

    @Column(name="motivo_cancelamento",columnDefinition ="TEXT",nullable = true )
    private String motivoCancelamento;
    @Column(name="data_criacao",nullable = false,updatable = false)
    private LocalDateTime dataCriacao;
    @Column(name="data_atauliazacao",nullable = true)
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name="atendente-id")
    private Usuario atendente;

    @ManyToOne
    @JoinColumn(name="solicitante-id")
    private Usuario solicitante;
    @PrePersist
    void aoCriar(){
        LocalDateTime agora=LocalDateTime.now();
        if(dataCriacao==null)
            dataCriacao=agora;
    }

}
