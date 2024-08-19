package com.API.API_CT.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.API_CT.domain.model.Presenca;

@RestController
@RequestMapping("/presenca")
public class PresencaController extends BaseController<Presenca, Long>  {
    
}
