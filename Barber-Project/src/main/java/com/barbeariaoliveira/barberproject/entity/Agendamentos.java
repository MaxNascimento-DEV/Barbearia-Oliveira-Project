package com.barbeariaoliveira.barberproject.entity;


import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import com.barbeariaoliveira.barberproject.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Agendamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barbeiro_id", nullable = false)
    private Barbeiro barbeiro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false )
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id", nullable = false)
    private Servicos servico;

    @Column(name = "data_hora_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_hora_fim", nullable = false)
    private LocalDateTime dataFim;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String observacao;

    @Column(name = "criado_em")
    private LocalDateTime criadoEM;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEM;

    @PrePersist
    public void prePersist(){
        criadoEM = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        atualizadoEM = LocalDateTime.now();
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status;

    

}
