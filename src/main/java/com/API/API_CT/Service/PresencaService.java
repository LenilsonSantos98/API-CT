package com.API.API_CT.Service;

import java.util.List;
import java.util.Optional;

import com.API.API_CT.domain.model.Presenca;


public interface PresencaService {
    List<Presenca> listarTodos();
    Presenca salvar(Presenca presenca);
    Optional<Presenca> buscarPorId(Long id);
    void exluir(Long id);
}
