package com.barbeariaoliveira.barberproject.controller;

import com.barbeariaoliveira.barberproject.entity.Barbeiro;
import com.barbeariaoliveira.barberproject.repository.BarbeiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")
@RequiredArgsConstructor

public class BarbeiroController {
    private final BarbeiroRepository barbeiroRepository;

    @GetMapping
    public List<Barbeiro> listarBareiros() {
        return barbeiroRepository.findByAtivoTrue();
    }
    @GetMapping("desativados")
    public List<Barbeiro> listarBarbeirosDesativados()
    {
        return barbeiroRepository.findByAtivoFalse();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Barbeiro adicionarBarbeiro(@RequestBody Barbeiro barbeiro)
    {
        return barbeiroRepository.save(barbeiro);
    }
}
