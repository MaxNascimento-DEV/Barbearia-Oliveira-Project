package com.barbeariaoliveira.barberproject.service;


import com.barbeariaoliveira.barberproject.entity.Servicos;
import com.barbeariaoliveira.barberproject.repository.ServicosRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ServicosService {

    private final ServicosRepository servicosRepository;

    public ServicosService(ServicosRepository servicosRepository) {
        this.servicosRepository = servicosRepository;
    }

    public List<Servicos> listarAtivos() {
        return servicosRepository.findByAtivoTrue();
    }

    public List<Servicos> listarTodos() {
        return servicosRepository.findAll();
    }

    public Servicos buscarPorId(Long id) {
        return servicosRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public Servicos cadastrar(Servicos servicos) {
        if (servicos.getNome() == null || servicos.getNome().isBlank()) {
            throw new RuntimeException("Nome do serviço não pode ser vazio");
        }
        if (servicosRepository.existsByNome(servicos.getNome().trim())) {
            throw new RuntimeException("Serviço já cadastrado");
        }
        if (servicos.getPreco() == null || servicos.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Preço do serviço não pode ser vazio ou menor que zero");
        }
        if (servicos.getDuracao() <= 0) {
            throw new RuntimeException("Duração do serviço não pode ser vazia ou menor que zero");
        }
        return servicosRepository.save(servicos);
    }

    public Servicos atualizar(Long id, Servicos servicos) {
        if (servicos.getNome() == null || servicos.getNome().isBlank()) {
            throw new RuntimeException("Nome do serviço não pode ser vazio");
        }
        if(servicos.getPreco() == null || servicos.getPreco().compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("Preço do serviço não pode ser vazio ou menor que zero");
        }
        if(servicos.getDuracao() <= 0){
            throw new RuntimeException("Duração do serviço não pode ser vazia ou menor que zero");
        }
        if (!servicosRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado");
        }
        servicos.setId(id);
        return servicosRepository.save(servicos);
    }

    public void desativar(Long id) {
        Servicos servicos = servicosRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        servicos.setAtivo(false);
        servicosRepository.save(servicos);
    }

    public void ativar(Long id) {
        Servicos servicos = servicosRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        servicos.setAtivo(true);
        servicosRepository.save(servicos);
    }

    public void deletar(Long id) {
        if (!servicosRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado");
        }
        servicosRepository.deleteById(id);
    }

}


