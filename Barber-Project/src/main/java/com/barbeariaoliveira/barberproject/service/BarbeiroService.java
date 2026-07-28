package com.barbeariaoliveira.barberproject.service;


import com.barbeariaoliveira.barberproject.entity.Barbeiro;
import com.barbeariaoliveira.barberproject.repository.BarbeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository){
        this.barbeiroRepository = barbeiroRepository;
    }

    public List<Barbeiro> listarAtivos(){
        return  barbeiroRepository.findByAtivoTrue();
    }

    public List<Barbeiro> listarDesativados(){
        return barbeiroRepository.findByAtivoFalse();
    }
    public List<Barbeiro> ListarTodos(){
        return barbeiroRepository.findAll();
    }

    public Barbeiro buscar(Long Id){
        return barbeiroRepository.findById(Id).orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));
    }
    public Barbeiro cadastrar(Barbeiro barbeiro){
        if(barbeiroRepository.existsByNome(barbeiro.getNome())){
            throw new RuntimeException("Barbeiro ja Cadastrado");
        }
        return barbeiroRepository.save(barbeiro);
    }



}
