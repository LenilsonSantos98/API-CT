package com.API.API_CT.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.API_CT.domain.model.Aula;

@Repository
public interface AulaRepository extends  JpaRepository<Aula, Long> {
    
}
