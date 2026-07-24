package com.barbeariaoliveira.barberproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "servicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Servicos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nome;

    private String descricao;

    private BigDecimal preco;

    private Boolean ativo = true;

    @Column(name = "criado_em")
    private LocalDateTime criadoEM;

    @PrePersist
    public void prePersist(){
        criadoEM = LocalDateTime.now();
    }
}
