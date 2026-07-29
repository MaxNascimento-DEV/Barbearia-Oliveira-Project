package com.barbeariaoliveira.barberproject.controller;


import com.barbeariaoliveira.barberproject.service.UsuarioService;
import com.barbeariaoliveira.barberproject.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listartodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPorId(@PathVariable long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> buscarPorNome(@PathVariable String nome){
        return usuarioService.buscarPorNome(nome);

    }
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioService.cadastrar(usuario);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario){
        return usuarioService.atualizar(usuario);
    }
}
