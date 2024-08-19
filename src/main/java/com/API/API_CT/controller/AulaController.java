package com.API.API_CT.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.API_CT.domain.model.Aula;

@RestController
@RequestMapping("/aula")
public class AulaController extends BaseController<Aula, Long> {
    
}
