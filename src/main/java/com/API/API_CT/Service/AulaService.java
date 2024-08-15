package com.API.API_CT.Service;

import java.util.List;
import java.util.Optional;

import com.API.API_CT.domain.model.Aula;


public interface AulaService {
    List<Aula> listarTodos();
    Aula salvar(Aula aula);
    Optional<Aula> buscarPorId(Long id);
    void exluir(Long id);
}
