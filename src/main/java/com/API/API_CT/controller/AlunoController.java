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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.API_CT.Service.AlunoService;
import com.API.API_CT.domain.model.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos(){
       List<Aluno> alunos = alunoService.listarTodos();
       return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id){
        Optional<Aluno> aluno = alunoService.buscarPorId(id);
        return aluno.map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        alunoService.exluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoExistente = alunoService.buscarPorId(id);
        if (alunoExistente.isPresent()) {
            Aluno alunoAtualizado = alunoExistente.get();
            alunoAtualizado.setNome(aluno.getNome());
            alunoAtualizado.setFaixa(aluno.getFaixa());
            alunoAtualizado.setTelefone(aluno.getTelefone());
            alunoService.salvar(alunoAtualizado);
            return ResponseEntity.ok(alunoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
