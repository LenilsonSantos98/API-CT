package com.API.API_CT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.API.API_CT.Service.BaseService;

public abstract class BaseController<T, ID> {

    @Autowired
    protected BaseService<T, ID> service;

    @GetMapping
    public ResponseEntity<List<T>> listarTodos() {
        List<T> entities;
        entities = service.listarTodos();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable ID id) {
        Optional<T> entity = service.buscarPorId(id);
        return entity.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<T> criar(@RequestBody T entity) {
        T novoEntity = service.salvar(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> atualizar(@PathVariable ID id, @RequestBody T entity) {
        Optional<T> entityExistente = service.buscarPorId(id);
        if (entityExistente.isPresent()) {
            T entityAtualizado = service.atualizar(id, entity);
            return ResponseEntity.ok(entityAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable ID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
