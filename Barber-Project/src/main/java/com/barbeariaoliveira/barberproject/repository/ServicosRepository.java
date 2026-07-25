package com.barbeariaoliveira.barberproject.repository;

import com.barbeariaoliveira.barberproject.entity.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicosRepository
        extends JpaRepository<Servicos, Long> {
}
