package com.barbeariaoliveira.barberproject.repository;

import com.barbeariaoliveira.barberproject.entity.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BarbeiroRepository
        extends JpaRepository<Barbeiro, Long> {
    List<Barbeiro> findByAtivoTrue();

    List<Barbeiro> findByAtivoFalse();
}
