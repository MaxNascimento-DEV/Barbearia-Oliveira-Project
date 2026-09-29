package com.barbeariaoliveira.barberproject.repository;

import com.barbeariaoliveira.barberproject.entity.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicosRepository
        extends JpaRepository<Servicos, Long> {

        List<Servicos> findByAtivoTrue();
        boolean existsByNome(String nome);
}
