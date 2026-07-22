package com.barbeariaoliveira.barberproject.controller;


import org.springframework.web.bind.annotation.*;
import com.barbeariaoliveira.barberproject.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.barbeariaoliveira.barberproject.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor

public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> ListarUsuarios() {
        return usuarioRepository.findAll();

    }
    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
