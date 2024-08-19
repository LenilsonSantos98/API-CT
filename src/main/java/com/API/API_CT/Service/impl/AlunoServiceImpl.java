package com.API.API_CT.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.API.API_CT.Service.AlunoService;
import com.API.API_CT.domain.model.Aluno;
import com.API.API_CT.domain.repository.AlunoRepository;

@Service
public class AlunoServiceImpl extends BaseServiceImpl<Aluno, Long> implements AlunoService {
    @Autowired
    private  AlunoRepository alunoRepository;

    public AlunoServiceImpl(JpaRepository<Aluno, Long> repository) {
        super(repository);
    }

    @Override
    public Optional<Aluno> buscarPorId(Long id) {
        
        return alunoRepository.findById(id);
    }
    
    @Override
    public Aluno atualizar(Long id, Aluno entity) {
        // Implementar lógica de atualização específica para Aluno.
        return super.atualizar(id, entity);
    }

    @Override
    public void exluir(Long id) {
        alunoRepository.deleteById(id);
        
    }

    @Override
    public List<Aluno> listarTodos() {
        
        return alunoRepository.findAll();
    }

    @Override
    public Aluno salvar(Aluno aluno) {
        
        return alunoRepository.save(aluno);
    }

    
}
