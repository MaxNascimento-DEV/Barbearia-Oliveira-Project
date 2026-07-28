package com.barbeariaoliveira.barberproject.repository;

import com.barbeariaoliveira.barberproject.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface UsuarioRepository
            extends JpaRepository<Usuario, Long> {
    boolean existsBytelefone(String telefone);
    boolean existsBynome(String nome);
    List<Usuario> findByNome(String nome);
}

