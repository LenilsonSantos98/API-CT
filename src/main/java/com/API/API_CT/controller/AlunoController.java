package com.API.API_CT.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.API_CT.domain.model.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController extends BaseController<Aluno, Long> {
   
}
