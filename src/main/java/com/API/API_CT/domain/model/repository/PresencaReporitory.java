package com.API.API_CT.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.API_CT.domain.model.Presenca;

@Repository
public interface PresencaReporitory extends JpaRepository<Presenca, Long> {
    
}
