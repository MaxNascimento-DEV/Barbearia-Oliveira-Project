package com.barbeariaoliveira.barberproject.repository;

import com.barbeariaoliveira.barberproject.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface UsuarioRepository
            extends JpaRepository<Usuario, Long> {
        // Additional query methods can be defined here if needed
    }

