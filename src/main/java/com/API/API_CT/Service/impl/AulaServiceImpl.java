package com.API.API_CT.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.API_CT.Service.AulaService;
import com.API.API_CT.domain.model.Aula;
import com.API.API_CT.domain.repository.AulaRepository;


@Service
public class AulaServiceImpl implements AulaService {
    @Autowired
    private  AulaRepository aulaRepository;

    @Override
    public Optional<Aula> buscarPorId(Long id) {
        
        return aulaRepository.findById(id);
    }

    @Override
    public void exluir(Long id) {
        aulaRepository.deleteById(id);
        
    }

    @Override
    public List<Aula> listarTodos() {
        
        return aulaRepository.findAll();
    }

    @Override
    public Aula salvar(Aula aula) {
        
        return aulaRepository.save(aula);
    }

}
