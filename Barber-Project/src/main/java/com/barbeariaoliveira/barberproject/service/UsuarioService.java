package com.barbeariaoliveira.barberproject.service;


import com.barbeariaoliveira.barberproject.entity.Usuario;
import com.barbeariaoliveira.barberproject.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos(){
        return  usuarioRepository.findAll();
    }

    public Usuario buscarPorId(long Id){
        return usuarioRepository.findById(Id).orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));
    }

    public List<Usuario> buscarPorNome(String nome){
        List<Usuario> usuarios = usuarioRepository.findByNome(nome);
        if(usuarios.isEmpty()){
            throw new RuntimeException("Usuario não encontrado");
    }
        return usuarios;
        }

    public Usuario cadastrar(Usuario usuario){
        if(usuarioRepository.existsBytelefone(usuario.getTelefone()) || usuarioRepository.existsBynome(usuario.getNome())){
            throw new RuntimeException("Usuario ja Cadastrado");
        }
        return usuarioRepository.save(usuario);
    }
    public Usuario atualizar(Usuario usuario){
        if(usuarioRepository.existsBynome(usuario.getNome()) || usuarioRepository.existsBytelefone(usuario.getTelefone())){
            throw new RuntimeException("Usuario ja Cadastrado");
        }
        return usuarioRepository.save(usuario);
    }


}
