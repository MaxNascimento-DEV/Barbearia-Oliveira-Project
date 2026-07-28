package com.barbeariaoliveira.barberproject.entity;


import com.barbeariaoliveira.barberproject.enums.Perfil;
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
    //Altera para Ativo Ou Inativo assim que inserir o usuario!.



    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Perfil perfil = Perfil.CLIENTE;


    @PrePersist
    public void prePersist() {
        criadoEm = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        atualizadoEm = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "usuario")
    private List<Agendamentos> agendamentos;
}
