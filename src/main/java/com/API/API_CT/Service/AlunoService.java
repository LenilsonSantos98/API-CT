package com.API.API_CT.Service;

import java.util.List;
import java.util.Optional;

import com.API.API_CT.domain.model.Aluno;


public interface AlunoService {
    List<Aluno> listarTodos();
    Aluno salvar(Aluno aluno);
    Optional<Aluno> buscarPorId(Long id);
    void exluir(Long id);

}
