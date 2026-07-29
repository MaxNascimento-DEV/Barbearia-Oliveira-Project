package com.barbeariaoliveira.barberproject.controller;

import com.barbeariaoliveira.barberproject.entity.Servicos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.barbeariaoliveira.barberproject.service.ServicosService;


import java.util.List;

@RestController
@RequestMapping("/servicos")


public class ServicosController {

    public final ServicosService servicosService;

    public ServicosController(ServicosService servicosService) {
        this.servicosService = servicosService;
    }

    @GetMapping("/ativos")
    @ResponseStatus(HttpStatus.OK)
    public List<Servicos> listarAtivos(){
        return servicosService.listarAtivos();
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Servicos> litarTodos(){
        return servicosService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Servicos buscarPorID(@PathVariable Long id){
        return servicosService.buscarPorId(id);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicos cadastrar(@RequestBody Servicos servicos) {
        return servicosService.cadastrar(servicos);
    }
    @PutMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Servicos atualizar(@PathVariable Long id, @RequestBody Servicos servicos) {
        return servicosService.atualizar(id, servicos);
    }

    @PatchMapping("/desativar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void desativar(@PathVariable Long id) {
        servicosService.desativar(id);
    }
    @PatchMapping("/ativar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void ativar(@PathVariable Long id) {
        servicosService.ativar(id);
    }

}
