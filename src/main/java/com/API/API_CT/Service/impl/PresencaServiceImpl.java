package com.API.API_CT.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.API.API_CT.Service.PresencaService;
import com.API.API_CT.domain.model.Presenca;
import com.API.API_CT.domain.repository.PresencaReporitory;

@Service
public class PresencaServiceImpl extends BaseServiceImpl<Presenca, Long> implements PresencaService {
    @Autowired
    private  PresencaReporitory presencaRepository;

    public PresencaServiceImpl(JpaRepository<Presenca, Long> repository) {
        super(repository);
    }

    @Override
    public Presenca atualizar(Long id, Presenca entity) {
        // Implementar lógica de atualização específica para Aluno.
        return super.atualizar(id, entity);
    }

    @Override
    public Optional<Presenca> buscarPorId(Long id) {
        
        return presencaRepository.findById(id);
    }

    @Override
    public void exluir(Long id) {
        presencaRepository.deleteById(id);
        
    }

    @Override
    public List<Presenca> listarTodos() {
        
        return presencaRepository.findAll();
    }

    @Override
    public Presenca salvar(Presenca presenca) {
        
        return presencaRepository.save(presenca);
    }

}
