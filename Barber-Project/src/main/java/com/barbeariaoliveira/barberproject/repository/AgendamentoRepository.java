package com.barbeariaoliveira.barberproject.repository;

import com.barbeariaoliveira.barberproject.entity.Agendamentos;
import com.barbeariaoliveira.barberproject.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository
        extends JpaRepository<Agendamentos, Long> {

    List<Agendamentos> findByBarbeiroId(Long barbeiroId);
    List<Agendamentos> findByUsuarioId(Long usuarioId);
    List<Agendamentos> findByStatus(StatusAgendamento status);

    boolean existsByBarbeiroIdAndDataInicio(
            Long barbeiroId,
            LocalDateTime dataInicio);

}
