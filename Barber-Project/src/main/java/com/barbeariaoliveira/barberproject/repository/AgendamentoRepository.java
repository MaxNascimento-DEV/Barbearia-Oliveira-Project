package com.barbeariaoliveira.barberproject.repository;

import com.barbeariaoliveira.barberproject.entity.Agendamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository
        extends JpaRepository<Agendamentos, Long> {
}
