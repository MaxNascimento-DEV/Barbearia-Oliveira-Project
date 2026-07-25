package com.barbeariaoliveira.barberproject.entity;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String telefone;

    @Column(unique = true)
    private String email;

    @Column
    private Boolean ativo;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;


    @PrePersist
    public void prePersist() {
        criadoEm = LocalDateTime.now();
    }

    @PrePersist
    public void preUpdate(){
        atualizadoEm = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "usuario")
    private List<Agendamentos> agendamentos;
}
