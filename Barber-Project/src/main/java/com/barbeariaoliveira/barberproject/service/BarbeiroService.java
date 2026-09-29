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
      if(barbeiro.getNome() == null || barbeiro.getNome().isBlank()) {
          throw new RuntimeException("Nome do barbeiro não pode ser vazio");
      }
      if(barbeiroRepository.existsByNome(barbeiro.getNome())){
            throw new RuntimeException("Barbeiro já cadastrado");
          }
        return barbeiroRepository.save(barbeiro);
    }

    public void ativar(Long Id){
        Barbeiro barbeiro = barbeiroRepository.findById(Id).orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));
        barbeiro.setAtivo(true);
        barbeiroRepository.save(barbeiro);
    }

    public void desativar(Long Id){
        Barbeiro barbeiro = barbeiroRepository.findById(Id).orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));
        barbeiro.setAtivo(false);
        barbeiroRepository.save(barbeiro);
    }


}
