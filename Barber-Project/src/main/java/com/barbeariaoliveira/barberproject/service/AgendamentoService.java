package com.barbeariaoliveira.barberproject.service;

import com.barbeariaoliveira.barberproject.repository.AgendamentoRepository;
import com.barbeariaoliveira.barberproject.repository.BarbeiroRepository;
import com.barbeariaoliveira.barberproject.repository.ServicosRepository;
import com.barbeariaoliveira.barberproject.repository.UsuarioRepository;

public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final BarbeiroRepository barbeiroRepository;
    private final ServicosRepository servicosRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, UsuarioRepository usuarioRepository, BarbeiroRepository barbeiroRepository, ServicosRepository servicosRepository){
        this.agendamentoRepository = agendamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.barbeiroRepository = barbeiroRepository;
        this.servicosRepository = servicosRepository;
    }


}

