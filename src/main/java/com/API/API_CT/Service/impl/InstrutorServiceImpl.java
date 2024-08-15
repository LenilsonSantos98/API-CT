package com.API.API_CT.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.API_CT.Service.InstrutorService;
import com.API.API_CT.domain.model.Instrutor;
import com.API.API_CT.domain.repository.InstrutorRepository;

@Service
public class InstrutorServiceImpl implements InstrutorService {
    @Autowired
    private  InstrutorRepository instrutorRepository;

    @Override
    public Optional<Instrutor> buscarPorId(Long id) {
        
        return instrutorRepository.findById(id);
    }

    @Override
    public void exluir(Long id) {
        instrutorRepository.deleteById(id);
        
    }

    @Override
    public List<Instrutor> listarTodos() {
        
        return instrutorRepository.findAll();
    }

    @Override
    public Instrutor salvar(Instrutor instrutor) {
        
        return instrutorRepository.save(instrutor);
    }

    
    
}
