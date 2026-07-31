package com.barbeariaoliveira.barberproject.service;

import com.barbeariaoliveira.barberproject.entity.Agendamentos;
import com.barbeariaoliveira.barberproject.entity.Barbeiro;
import com.barbeariaoliveira.barberproject.entity.Servicos;
import com.barbeariaoliveira.barberproject.entity.Usuario;
import com.barbeariaoliveira.barberproject.enums.StatusAgendamento;
import com.barbeariaoliveira.barberproject.repository.AgendamentoRepository;
import com.barbeariaoliveira.barberproject.repository.BarbeiroRepository;
import com.barbeariaoliveira.barberproject.repository.ServicosRepository;
import com.barbeariaoliveira.barberproject.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final BarbeiroRepository barbeiroRepository;
    private final ServicosRepository servicosRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, UsuarioRepository usuarioRepository,
                              BarbeiroRepository barbeiroRepository, ServicosRepository servicosRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.barbeiroRepository = barbeiroRepository;
        this.servicosRepository = servicosRepository;
    }

    public List<Agendamentos> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public Agendamentos buscarPorId(Long id) {
        return agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public Agendamentos cadastrar(Agendamentos agendamentos) {
        Usuario usuario = usuarioRepository.findById(agendamentos.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Barbeiro barbeiro = barbeiroRepository.findById(agendamentos.getBarbeiro().getId())
                .orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));
        if(!barbeiro.getAtivo()) {
            throw new RuntimeException("Barbeiro não está ativo");
        }
        Servicos servicos = servicosRepository.findById(agendamentos.getServicos().getId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        if(!servicos.getAtivo()){
            throw new RuntimeException("Serviço não está ativo");
        }
        if(agendamentoRepository.existsByBarbeiroIdAndDataInicio(barbeiro.getId(), agendamentos.getDataInicio())){
            throw new RuntimeException("Barbeiro já possui um agendamento nesse horário");
        }

        agendamentos.setStatus(StatusAgendamento.AGENDADO);

        agendamentos.setDataFim(agendamentos.getDataInicio().plusMinutes(servicos.getDuracao()));
        return agendamentoRepository.save(agendamentos);
    }
}


