package com.API.API_CT.Service;

import java.util.List;
import java.util.Optional;

import com.API.API_CT.domain.model.Instrutor;


public interface InstrutorService {
    List<Instrutor> listarTodos();
    Instrutor salvar(Instrutor instrutor);
    Optional<Instrutor> buscarPorId(Long id);
    void exluir(Long id);
    
   
}
