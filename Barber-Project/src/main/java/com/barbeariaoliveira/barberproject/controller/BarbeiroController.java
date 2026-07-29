package com.barbeariaoliveira.barberproject.controller;

import com.barbeariaoliveira.barberproject.entity.Barbeiro;
import com.barbeariaoliveira.barberproject.service.BarbeiroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")


public class BarbeiroController {
    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService) {
        this.barbeiroService = barbeiroService;
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Barbeiro> listarTodos() {
        return barbeiroService.ListarTodos();
    }

    @GetMapping("/ativos")
    @ResponseStatus(HttpStatus.OK)
    public List<Barbeiro> listarAtivos() {
        return barbeiroService.listarAtivos();
    }

    @GetMapping("/desativados")
    @ResponseStatus(HttpStatus.OK)
    public List<Barbeiro> listarDesativados() {
        return barbeiroService.listarDesativados();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Barbeiro buscar(@PathVariable Long id) {
        return barbeiroService.buscar(id);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Barbeiro cadastrar(@RequestBody Barbeiro barbeiro){
        return barbeiroService.cadastrar(barbeiro);
    }
}
