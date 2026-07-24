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

    @Column(name = "usuario_id")
    private String usuarioID;

    @Column(name = "barbairo_id")
    private String barbeiroID;

    @Column(name = "servico_id")
    private String servicoID;

    @Column(name = "data_hora_inicio")
    private LocalDate DataInicio;

    @Column(name = "data_hora_fim")
    private LocalDate DataFim;

    private String observacao;

    @Column(name = "criado_em")
    private LocalDateTime criadoEM;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEM;

    @PrePersist
    public void prePersist(){
        criadoEM = LocalDateTime.now();
    }
    @PrePersist
    public void preUpdate(){
        atualizadoEM = LocalDateTime.now();
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barbeiro_id")
    private Barbeiro barbeiro;

}
