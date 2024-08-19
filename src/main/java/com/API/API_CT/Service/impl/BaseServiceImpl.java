package com.API.API_CT.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.API.API_CT.Service.BaseService;

public class BaseServiceImpl <T, ID> implements BaseService<T, ID>{
    
    protected final JpaRepository<T, ID> repository;

    protected  BaseServiceImpl(JpaRepository<T, ID> repository){
        this.repository = repository;
    }

    @Override
    public List<T> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return repository.findById(id);
    }

    @Override
    public T salvar(T entity) {
        return repository.save(entity);
    }

    @Override
    public T atualizar(ID id, T entity) {
        // serviços específicos.
        return repository.save(entity);
    }

    @Override
    public void excluir(ID id) {
        repository.deleteById(id);
    }
}


    

