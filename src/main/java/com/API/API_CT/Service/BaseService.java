package com.API.API_CT.Service;

import java.util.List;
import java.util.Optional;

public interface  BaseService <T, ID> {
    List<T> listarTodos();
    Optional<T> buscarPorId(ID id);
    T salvar(T entity);
    T atualizar(ID id, T entity);
    void excluir(ID id);
}
